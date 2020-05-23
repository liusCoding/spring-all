package com.liuscoding.ext;

import com.liuscoding.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 *  扩展原理:
 *  BeanPostProcessor:  bean后置处理器，bean创建对象初始化前后进行工作的
 *
 *  1、BeanFactoryPostProcessor：beanFactory的后置处理器；
 *      在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 *      所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 *
 *  BeanFactoryPostProcessor原理:
 *      1)、ioc容器创建对象
 *      2)、invokeBeanFactoryPostProcessors(beanFactory);
 *          如何找到所有的BeanFactoryPostProcessor并执行他们的方法；
 *              1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *              2）、在初始化创建其他组件前面执行
 *
 *
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor.
 *      postProcessBeanDefinitionRegistry();
 *      在所有bean定义信息将要被加载，bean实例还未创建的；
 *
 *      优先于BeanFactoryPostProcessor执行；
 *      利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件；
 *
 *  原理：
 *      1）、ioc创建对象
 *      2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
 *      3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
 *          	1、依次触发所有的postProcessBeanDefinitionRegistry()方法
 *             	2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；
 *    	4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法
 *
 *  3、ApplicationListener：监听容器中发布的事件。事件驱动模型开发；
 *     public interface ApplicationListener<E extends ApplicationEvent>
 *       监听 ApplicationEvent 及其下面的子事件；
 *
 *   步骤：
 *      1）、写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）
 *      @EventListener;
 *      原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener；
 *      2）、把监听器加入到容器；
 *      3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 *          ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件；
 *          ContextClosedEvent：关闭容器会发布这个事件；
 *     4）、发布一个事件：
 *          	applicationContext.publishEvent()；
 *
 */
@Configuration
@ComponentScan("com.liuscoding.ext")
public class ExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
