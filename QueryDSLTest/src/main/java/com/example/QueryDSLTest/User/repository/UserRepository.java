package com.example.QueryDSLTest.User.repository;

import com.example.QueryDSLTest.User.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserByEmail(String email);

}
