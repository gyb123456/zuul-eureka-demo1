package com.example.eurekademo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestCtrl {
    @GetMapping("aaa")
    public String test(){
        return "eureke-demo";
    }
}
