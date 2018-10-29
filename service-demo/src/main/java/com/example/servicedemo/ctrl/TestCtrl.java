package com.example.servicedemo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestCtrl {
    @GetMapping("aaa")
    public String test(){
        return "servicedemo-aaaa";
    }

    @GetMapping("bbb")
    public String bbb(){
        return "servicedemo-bbbb";
    }
}
