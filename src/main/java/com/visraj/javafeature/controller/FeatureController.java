package com.visraj.javafeature.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeatureController {

    @GetMapping("/greet")
    public String greet() {

        return "Hi Sarath!";
    }
}