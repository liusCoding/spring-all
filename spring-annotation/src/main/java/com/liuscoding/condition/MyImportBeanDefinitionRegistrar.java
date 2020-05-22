package com.liuscoding.condition;

import com.liuscoding.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @className: MyImportBeanDefinitionRegistrar
 * @description:
 * @author: liusCoding
 * @create: 2020-05-22 20:37
 */

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     *
     * @param importingClassMetadata annotation metadata of the importing class  当前类的注解的信息
     * @param registry               current bean definition registry   BeanDefinition注册类
     *
     *   把所有需要添加到容器中的bean； 调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     *
     *
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean red = registry.containsBeanDefinition("com.liuscoding.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.liuscoding.bean.Blue");

        if (red && blue){

            //指定bean的定义信息（Bean 的类型 或 作用域）
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean 指定bean 和定义信息
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
