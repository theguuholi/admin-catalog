package com.example.admin_catalog;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hi() {
        String name = System.getenv("NAME");
        String age = System.getenv("AGE");
        return "Hello, I am " + name + "I`m " + age;
    }

    @GetMapping("/secrets")
    public String secrets() {
        String name = System.getenv("USER");
        String age = System.getenv("PASSWORD");
        return "Hello, I am " + name + "I`m " + age;
    }

    @GetMapping("/configmap")
    public String configMap() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("myFamly/family.txt")));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file";
        }
    }

}
