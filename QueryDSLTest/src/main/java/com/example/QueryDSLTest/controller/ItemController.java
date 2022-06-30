package com.example.QueryDSLTest.controller;

import com.example.QueryDSLTest.model.ItemEntity;
import com.example.QueryDSLTest.model.ItemResponse;
import com.example.QueryDSLTest.model.QItemEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/test/item")
public class ItemController {

    @Autowired
    EntityManager entityManager;

    @GetMapping
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemResponse> readAll()
    {
        ItemEntity itemEntityPersist = new ItemEntity();
        entityManager.persist(itemEntityPersist);

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QItemEntity qItem = new QItemEntity("i");
        ItemEntity itemEntity = queryFactory.selectFrom(qItem).fetchOne();

        List<ItemEntity> itemEntities = new ArrayList<>();
        itemEntities.add(itemEntity);

        // List<ItemEntity> itemEntities = this.itemService.searchAll();

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setStatus("200");
        itemResponse.setError("success");
        itemResponse.setItemEntities(itemEntities);

        return ResponseEntity.ok(itemResponse);
    }

}
