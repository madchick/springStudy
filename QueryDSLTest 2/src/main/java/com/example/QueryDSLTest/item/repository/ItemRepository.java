package com.haksik.haksikapi.item.repository;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi.item.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findAll();
    List<ItemEntity> findAllByMenuIdOrderByCreatedDateDesc(Long menuId);

    List<ItemEntity> findByShopIdAndMealType(Long shopId, MealType type);

    ItemEntity findByItemIdOrderByCreatedDateDesc(Long itemId);
}
