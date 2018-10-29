package com.example.servicedemo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("eureka")
public class EurekaCtrl {
    @GetMapping("aaa")
    public String test(){
        return "service---eureka";
    }
}
