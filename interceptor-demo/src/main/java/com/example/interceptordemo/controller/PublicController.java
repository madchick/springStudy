package com.example.interceptordemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public String Hello() {
        log.info("public hello controller");
        return "public Hello";
    }
}
