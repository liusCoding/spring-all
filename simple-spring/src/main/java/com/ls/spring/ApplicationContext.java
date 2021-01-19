package com.ls.spring;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    /**
     * bean定义信息
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();
    //Spring的启动流程
    public ApplicationContext(Class configClazz) {
        //扫描类  得到BeanDefinition
        scan(configClazz);

        //实例化非懒加载的实例Bean
        //1.实例化
        //2.属性填充
        //3.Aware回调
        //4.初始化
        //5.添加到单例池
        instanceSingletonBean();
    }

    private void instanceSingletonBean() {
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals(ScopeEnum.singleton)) {
                Object bean = doCreateBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }

        }
    }

    /**
     * 基于BeanDefinition来创建bean
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义信息
     * @return
     */
    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            //1.实例化
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            Object instance = declaredConstructor.newInstance();

            //2.属性填充
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                if(field.isAnnotationPresent(Autowired.class)){
                    String fieldName = field.getName();
                    Object bean = getBean(fieldName);
                    field.setAccessible(true);
                    field.set(instance,bean);
                }
            }


            //3.NameAware 回调
            if(instance instanceof BeanNameAware){
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            //4.初始化
            if(instance instanceof InitialzingBean){
                ((InitialzingBean) instance).afterPropertiesSet();
            }

            //5.后置处理
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                beanPostProcessor.postProcessAfterInitialization(beanName,instance);
            }
            return instance;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getBean(String beanName) {
        if(singletonObjects.containsKey(beanName)){
            return singletonObjects.get(beanName);
        }else {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
           return doCreateBean(beanName,beanDefinition);
        }
    }

    private void scan(Class configClazz) {
        // 扫描class， 转化为 BeanDefinition 对象，最后添加到 beanDefinition

        ComponentScan componentScan = (ComponentScan) configClazz.getAnnotation(ComponentScan.class);
        //得到扫描的包路径
        String packagePath = componentScan.value();
        //System.out.println(packagePath);

        List<Class> classList = getBeanClasses(packagePath);

        //遍历classList 得到BeanDefinition
        for (Class clazz : classList) {
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClass(clazz);
            //要么Spring自动生成 要么从Component注解上获取
            Component component = (Component) clazz.getAnnotation(Component.class);
            String beanName = component.value();
//            System.out.println(beanName);

            if(BeanPostProcessor.class.isAssignableFrom(clazz)){
                try {
                    BeanPostProcessor instance = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                    beanPostProcessorList.add(instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }

            //解析scope
            if (clazz.isAnnotationPresent(Scope.class)) {
                Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                String scopeValue = scope.value();
                if (ScopeEnum.singleton.name().equals(scopeValue)) {
                    beanDefinition.setScope(ScopeEnum.singleton);
                } else {
                    beanDefinition.setScope(ScopeEnum.prototype);
                }

            } else {
                beanDefinition.setScope(ScopeEnum.singleton);
            }
            beanDefinitionMap.put(beanName, beanDefinition);
        }
    }

    // 扫描包路径得到classList
    private List<Class> getBeanClasses(String packagePath) {
        List<Class> classList = new ArrayList<>();
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        packagePath = packagePath.replace(".", "/");
//        System.out.println(packagePath);
        URL resource = classLoader.getResource(packagePath);
//        System.out.println(resource);
        File file = new File(resource.getFile());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
//                System.out.println(fileName);
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    className = className.replace("\\", ".");
//                    System.out.println(className);

                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        classList.add(clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classList;
    }
}
