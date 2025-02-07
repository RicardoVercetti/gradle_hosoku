package com.ricardo.hosoku;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from Hosoku API! Altered";
    }
}
