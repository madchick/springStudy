package com.example.jpademo.repository;

import com.example.jpademo.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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

        userRepository.saveAndFlush(new User("new martin", "martini@fast.com"));
        // userRepository.flush();
        userRepository.findAll().forEach(System.out::println);

        long count = userRepository.count();
        System.out.println(count);

        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);

        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

        userRepository.deleteAll(userRepository.findAllById((Lists.newArrayList(2L, 3L))));
        userRepository.findAll().forEach(System.out::println);

        userRepository.deleteAllInBatch(userRepository.findAllById((Lists.newArrayList(4L, 5L))));
        userRepository.findAll().forEach(System.out::println);

        Page<User> pagingUsers = userRepository.findAll(PageRequest.of(0,3));
        System.out.println("page : " + pagingUsers);
        System.out.println("total count : " + pagingUsers.getTotalElements());
        System.out.println("total pages : " + pagingUsers.getTotalPages());
        System.out.println("number of elements : " + pagingUsers.getNumberOfElements());
        System.out.println("sort : " + pagingUsers.getSort());
        System.out.println("size : " + pagingUsers.getSize());
        pagingUsers.getContent().forEach(System.out::println);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", contains());
        User user = new User();
        user.setEmail("slow");
        Example<User> example = Example.of(user, matcher);
        userRepository.findAll(example).forEach(System.out::println);

        User userUpdate = userRepository.findById(7L).orElseThrow(RuntimeException::new);
        userUpdate.setEmail("martin-updated@fastcampus.com");
        userRepository.save(userUpdate);
    }

}