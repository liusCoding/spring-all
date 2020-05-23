package com.liuscoding.config;


import com.liuscoding.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *  Spring 为我们提供可以根据当前环境，动态激活和切换一系列组件的功能；
 *
 *  开发环境、测试环境、生产环境、
 *  数据源：（/A）(/B)(/C)
 *
 * @Rrofile； 指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *     1. 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境。
 *     2. 写在配置类上，只有是指定的环境的时候，整个配置类里面的所有环境才能开始生效。
 *     3. 没有标注环境标识的bean在，任何环境下都是加载的。
 *
 * @author liuscoding
 */

@PropertySource("classpath:dbconfig.properties")
@Configuration
//@Profile("dev")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;


    @Bean
    public Yellow yellow(){
        return new Yellow();
    }


    @Profile("test")
    @Bean("testDatasource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mall");
        dataSource.setDriverClass(driverClass);
        return dataSource;

    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource devDataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test50");
        dataSource.setDriverClass(driverClass);
        return dataSource;

    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource prodDataSource(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/guli");
        dataSource.setDriverClass(driverClass);
        return dataSource;

    }


    /**
     * Set the StringValueResolver to use for resolving embedded definition values.
     *
     * @param resolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        this.driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
