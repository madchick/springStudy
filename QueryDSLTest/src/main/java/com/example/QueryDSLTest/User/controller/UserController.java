package com.example.QueryDSLTest.User.controller;

import com.example.QueryDSLTest.User.model.UserEntity;
import com.example.QueryDSLTest.User.model.UserResponse;
import com.example.QueryDSLTest.User.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/browse")
    public ResponseEntity<UserResponse> findByEmail(@RequestParam String email) {
        List<UserEntity> userEntities = this.userService.findUserByEmail(email);

        UserResponse userResponse = new UserResponse();
        userResponse.setStatus("200");
        userResponse.setError("success");
        userResponse.setUserEntities(userEntities);

        return ResponseEntity.ok(userResponse);
    }

}
