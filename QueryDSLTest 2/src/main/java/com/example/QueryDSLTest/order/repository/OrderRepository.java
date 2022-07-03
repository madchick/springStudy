package com.haksik.haksikapi.order.repository;

import com.haksik.haksikapi.order.model.OrderEntity;
import com.haksik.haksikapi.order.model.OrderinfoView;
import com.haksik.haksikapi.sales.model.SalesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAll();

    String joinQuery =
        "select ts2.school_id as schoolId, ts2.school_name as schoolName, " +
        "ts.shop_id as shopId, ts.shop_name as shopName, " +
        "tm.menu_id as menuId, tm.menu_name as menuName, tm.menu_picture as menuPicture, tm.menu_desc as menuDesc, tm.menu_detail_desc as menuDetailDesc, " +
        "tm.menu_price as ticketPrice, ti.meal_type as mealType, ti.item_bundle_count itemBundleCount " +
        "from tb_item ti, tb_menu tm, tb_shop ts, tb_school ts2 " +
        "where ti.item_id = :itemId and ti.menu_id = tm.menu_id and tm.shop_id = ts.shop_id and ts.school_id = ts2.school_id";
    @Query(value = joinQuery, nativeQuery = true)
    OrderinfoView findOrderInfo(@Param("itemId") Long itemId);

}
