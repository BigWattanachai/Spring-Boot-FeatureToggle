package com.example.featureToggle.controllers;

import com.example.featureToggle.FeatureToggle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @FeatureToggle(feature = "hello.feature")
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name;
    }
}
