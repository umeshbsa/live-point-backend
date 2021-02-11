package com.app.livepoint.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class SignUpController {

    @GetMapping("/get")
    public String getData() {
        return "Hello";
    }
}
