package com.example.validationannotationdemo.controller;

import com.example.validationannotationdemo.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(ojbectError -> {
                FieldError field = (FieldError) ojbectError;
                String message = ojbectError.getDefaultMessage();

                System.out.println("field : " + field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : " + message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        System.out.println(user);
        return ResponseEntity.ok(user);
    }

}
