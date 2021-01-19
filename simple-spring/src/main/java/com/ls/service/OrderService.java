package com.ls.service;

import com.ls.spring.*;

@Component("orderService")
@Scope("prototype")
public class OrderService implements BeanNameAware, InitialzingBean {

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    private UserService userService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化属性之后设置！");
    }
}
