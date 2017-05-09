package com.ting.controller;

import com.ting.dao.GirlRepository;
import com.ting.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ting on 2017/5/9.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    //http://127.0.0.1:8080/spring-boot-demo/girls
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    //http://127.0.0.1:8080/spring-boot-demo/addGirl?cupSize=B&age=19
    @GetMapping("/addGirl")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        Girl save = girlRepository.save(girl);
        return save;
    }

    //http://127.0.0.1:8080/spring-boot-demo/findGirl/1
    @GetMapping("/findGirl/{id}")
    public Girl findGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }


    //http://127.0.0.1:8080/spring-boot-demo/updateGirl/1?cupSize=B&age=19
    @GetMapping("/updateGirl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){

        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }


    //http://127.0.0.1:8080/spring-boot-demo/delGril/1
    @GetMapping("/delGril/{id}")
    public void delGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //http://127.0.0.1:8080/spring-boot-demo/girls/age/19
    @GetMapping("/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){

        return girlRepository.findByAge(age);
    }

}
