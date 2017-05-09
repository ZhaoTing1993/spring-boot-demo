package com.ting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ting on 2017/5/9.
 */
@RestController//Spring4后新加的注解,等于原来@ResponseBody配合@Controller使用的效果
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping("/hello")
    public String say(){
//        return "Hello Spring Boot!"+cupSize;
        return content;
    }

    @RequestMapping("/hello2")
    public String say2(){
        return girlProperties.getAge()+":"+girlProperties.getCupSize();
    }
}
