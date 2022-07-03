package com.haksik.haksikapi.menu.repository;

import com.haksik.haksikapi.menu.model.MenuEntity;
import com.haksik.haksikapi.menu.model.MenuGroupView;
import com.haksik.haksikapi.order.model.OrderinfoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    List<MenuEntity> findByShopId(Long shopId);

    MenuEntity findByMenuId(Long menuId);

    List<MenuEntity> findAll();

    String joinQuery =
        "select tm.menu_id as menuId, tm.menu_name as menuName, tm.menu_price as menuPrice, " +
        "ts.shop_id as shopId, ts.shop_name as shopName, " +
        "tsc.school_id as schoolId, tsc.school_name as schoolName, " +
        "tm.ticket_type as ticketType, tm.menu_desc as menuDesc, tm.meal_type as mealType, " +
        "tm.menu_detail_desc as menuDetailDesc, tm.menu_picture as menuPicture, tm.created_date as createdDate, tm.enabled as enabled, " +
        "tm.gopublic_type as gopublicType, tm.sales_status_type as salesStatusType, tm.sales_start_date as salesStartDate, tm.sales_stop_date as salesStopDate " +
        "from tb_menu as tm, tb_shop as ts, tb_school as tsc " +
        "where tm.shop_id = ts.shop_id and ts.school_id = tsc.school_id ";
    @Query(value = joinQuery, nativeQuery = true)
    List<MenuGroupView> findAllMenu(@Param("schoolId") Long schoolId);

}
