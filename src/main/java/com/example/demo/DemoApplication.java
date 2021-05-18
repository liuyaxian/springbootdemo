package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.run;
//@SpringBootApplication(scanBasePackages = "com.example")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.example")
public class DemoApplication {

	public static void main(String[] args) {
    // 1、返回我们 ioc容器
		ConfigurableApplicationContext run =  SpringApplication.run(DemoApplication.class, args);
	// 2、查看容器里面的组件
		String[] names = run.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
