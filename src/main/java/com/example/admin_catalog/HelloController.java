package com.example.admin_catalog;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hi() {
        return "Hello!!";
    }
    
}
