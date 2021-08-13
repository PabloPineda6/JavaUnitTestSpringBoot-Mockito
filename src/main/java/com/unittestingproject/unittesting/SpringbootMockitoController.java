package com.unittestingproject.unittesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootMockitoController {
    @GetMapping("/get-response")
    public String simpleController(){
        return "Text to be retrieved";
    }
}
