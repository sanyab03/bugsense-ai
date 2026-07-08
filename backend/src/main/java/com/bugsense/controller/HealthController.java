package com.bugsense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "BugSense AI Backend is Running!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}