package com.example.jpademo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void entityTestManagerTest() {
        // System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

}
