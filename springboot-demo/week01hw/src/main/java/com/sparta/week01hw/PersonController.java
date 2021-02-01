package com.sparta.week01hw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getCourses() {
        Person person = new Person();
        person.setName("오광섭");
        person.setAge(18);
        person.setAddress("역삼동");
        person.setJob("백수");
        return person;
    }
}
