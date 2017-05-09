package com.ting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello
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
    public String say() {
    //  return "Hello Spring Boot!"+cupSize;
        return content;
    }

    //    multi url mapping adapt
    @RequestMapping(value = {"/hello2", "/hello3"})
    public String multiSay() {
        return girlProperties.getAge() + ":" + girlProperties.getCupSize();
    }

/**you can run following examples by ctrl+click on url*/

    // url mapping could be dynamic
    // example: http://127.0.0.1:8080/spring-boot-demo/say/1
    // output: id:1
    @RequestMapping(value = {"/say/{id}"})
    public String dynamicSay(@PathVariable("id") Integer id) {
        return "id:" + id;
    }

    // get request param
    // example: http://127.0.0.1:8080/spring-boot-demo/say?id=123
    // output: id:123
    @RequestMapping(value = {"/say"})
    public String sayWithParam(@RequestParam("id") Integer id) {
        return "id:" + id;
    }

}
