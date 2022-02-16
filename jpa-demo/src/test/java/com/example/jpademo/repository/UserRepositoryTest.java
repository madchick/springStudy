package com.example.jpademo.repository;

import com.example.jpademo.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new User());

        User user1 = new User("Jack","jack@naver.com");
        User user2 = new User("steve","steve@slow.com");
        userRepository.saveAll(Lists.newArrayList(user1,user2));

        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
        users.forEach(System.out::println);

        users = userRepository.findAllById(Lists.newArrayList(1L, 2L, 3L));
        users.forEach(System.out::println);

        Optional<User> user3 = userRepository.findById(1L);
        System.out.println(user3);

        User user4 = userRepository.findById(2L).orElse(null);
        System.out.println(user4);

    }

}