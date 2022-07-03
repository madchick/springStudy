package com.example.QueryDSLTest.User.service;

import com.example.QueryDSLTest.User.model.UserEntity;
import com.example.QueryDSLTest.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

}
