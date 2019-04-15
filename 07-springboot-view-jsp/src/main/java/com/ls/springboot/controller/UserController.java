package com.ls.springboot.controller;

import com.ls.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Springboot整合jsp
 *
 */
@Controller
public class UserController {
    /**
     * 产生请求
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){

        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",20));
        list.add(new User(2,"李四",22));
        list.add(new User(3,"王五",24));

        //需要一个Model对象
        model.addAttribute("list",list);

        //跳转视图
        return "userList";

    }

    @RequestMapping("hello")
    @ResponseBody
    public String getMessage(){
        return "hello";
    }
}
