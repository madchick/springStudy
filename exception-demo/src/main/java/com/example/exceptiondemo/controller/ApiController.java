package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("")
    public User get(@Valid @RequestParam(required = false) String name, @RequestParam(required = false) int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;
        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }

}
