package com.haksik.haksikapi.shop.repository;

import com.haksik.haksikapi.sales.model.SalesCountView;
import com.haksik.haksikapi.shop.model.ShopEntity;
import com.haksik.haksikapi.shop.model.ShopItemCountView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    List<ShopEntity> findAll();

    List<ShopEntity> findBySchoolId(Long schoolId);

    String countQuery =
        "select mt.mealType, IFNULL(ti.itemCount,0) as itemCount from " +
        "(WITH RECURSIVE A AS (SELECT 0 AS mealType UNION ALL SELECT 1+A.mealType FROM A WHERE A.mealType <3) SELECT mealType FROM A) as mt " +
        "left join (select ti.meal_type as mealType, count(*) as itemCount from tb_item ti where ti.shop_id = :shopId group by ti.meal_type) as ti " +
        "on mt.mealType = ti.mealType";
    @Query(value = countQuery, nativeQuery = true)
    List<ShopItemCountView> countShopItem(@Param("shopId") Long shopId);

}
