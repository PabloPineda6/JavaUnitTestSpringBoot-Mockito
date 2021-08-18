package com.unittestingproject.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSpringBootMockitoController {
    @GetMapping("/get-response")
    public String simpleController(){
        return "Text to be retrieved";
    }
}
