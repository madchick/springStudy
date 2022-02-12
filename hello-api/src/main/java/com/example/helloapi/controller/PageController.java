package com.example.helloapi.controller;

import com.example.helloapi.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public UserRequest user() {
        var user = new UserRequest();
        user.setName("madchick");
        user.setEmail("가나다라");
        user.setAge(50);
        return user;
    }

}
