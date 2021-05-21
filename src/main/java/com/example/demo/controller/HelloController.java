package com.example.demo.controller;

import ch.qos.logback.classic.db.DBAppender;
import com.example.demo.bean.Car;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
// 给容器中自动创建两个类型的组件
@RequestMapping(value = "/", produces = "application/json; charset=utf-8")
@Import({User.class, DBAppender.class})
@RestController
public class HelloController {

    @Autowired
    private Car car;
    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return  "hello  spring boot2!中文 ";
    }
}
