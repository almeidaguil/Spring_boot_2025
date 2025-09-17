package com.example.rest_with_spring_boot_and_java.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_with_spring_boot_and_java.model.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=John
    @RequestMapping("/greeting")
    public Greeting greeting
            (@RequestParam(value = "name", defaultValue = "World")
            String name) {
        return new Greeting(
            counter.incrementAndGet(),
            String.format(template, name));
    }
}
