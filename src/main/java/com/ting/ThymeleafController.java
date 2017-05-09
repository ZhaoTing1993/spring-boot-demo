package com.ting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ting on 2017/5/9.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
