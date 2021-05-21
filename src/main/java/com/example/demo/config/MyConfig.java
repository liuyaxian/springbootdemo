package com.example.demo.config;

import ch.qos.logback.core.db.DBHelper;
import com.example.demo.bean.Car;
import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author admin
 */
// 这是一个配置类， 同之前的配置文件 beans.xml
//@Configuration()
//@Configuration(proxyBeanMethods=false)
    //给容器中自动创建出这两个类型的组件
@Import({User.class, DBHelper.class})
@Configuration()
//@ConditionalOnBean(name = "tom1")
// 条件装备， 容器中有tom1时操作
// 导入spring。xml配置文件生效
@ImportResource("classpath:beans.xml")
// 开启carde 属性配置功能   配置文件中的类
@EnableConfigurationProperties(Car.class)
public class MyConfig {

//    @ConditionalOnBean(name = "tom")
    @Bean()
    // 给容器中添加组件  方法名为组件的id = use01  返回的类型为组件类型，  方法返回的值为组件在容器中实例
    public User user01(){
        User  user = new User("zjag", 11);
        user.setPet(new Pet("eeee"));
        return user;
    }
//    @Bean("tt")
//   @ConditionalOnBean(name = "tom")
    public Pet tomcatPet(){
        return new Pet("tomcat1");
    }
}
