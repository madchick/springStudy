package com.haksik.haksikapi.ticket.repository;

import com.haksik.haksikapi.sales.model.SalesCountView;
import com.haksik.haksikapi.ticket.model.TicketEntity;
import com.haksik.haksikapi.ticket.model.TicketGroupView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {

    List<TicketEntity> findAll();

    List<TicketEntity> findAllByUserId(Long userId);

    List<TicketEntity> findByTicketIdAndUserId(Long ticketId, Long userId);

    TicketEntity findByTicketId(Long ticketId);

    String havingQuery =
        "select tt.ticket_id as ticketId, tt.user_id as userId, tt.order_id as orderId, " +
        "tt.school_id as schoolId, tt.school_name as schoolName, tt.shop_id as shopId, tt.shop_name as shopName, " +
        "tt.menu_id as menuId, tt.menu_name as menuName, tt.menu_picture as menuPicture, " +
        "tt.price as price, tt.meal_type as mealType, tt.ticket_type as ticketType, " +
        "tt.ticket_desc as ticketDesc, tt.ticket_detail_desc as ticketDetailDesc, tt.item_id itemId, tt.item_count itemCount, " +
        "tt.created_date as createdDate, tt.modified_date as modifiedDate " +
        "from tb_ticket tt left join tb_sales ts on tt.ticket_id = ts.ticket_id " +
        "where tt.user_id = :userId and ts.ticket_id is NULL";
    @Query(value = havingQuery, nativeQuery = true)
    List<TicketEntity> findTicketHaving(@Param("userId") Long userId);

    String havingGroupQuery =
        "select tt.order_id as orderId, tt.school_name as schoolName, tt.shop_name as shopName, " +
        "tt.ticket_type as ticketType, tt.meal_type as mealType, " +
        "tt.menu_picture as menuPicture, tt.menu_name as menuName, DATE_FORMAT(tt.created_date,'%Y-%m-%d') as buyDate, " +
        "tt.price as ticketPrice, tt.item_count as totalCount, count(*) as itemCount " +
        "from tb_ticket tt left join tb_sales ts on tt.ticket_id = ts.ticket_id " +
        "where tt.user_id = :userId and ts.ticket_id is NULL " +
        "group by orderId, schoolName, shopName, ticketType, mealType, menuPicture, menuName, buyDate, ticketPrice, totalCount order by orderId desc";
    @Query(value = havingGroupQuery, nativeQuery = true)
    List<TicketGroupView> findTicketHavingGroup(@Param("userId") Long userId);

    String usedQuery =
        "select tt.ticket_id as ticketId, tt.user_id as userId, tt.order_id as orderId, " +
        "tt.school_id as schoolId, tt.school_name as schoolName, tt.shop_id as shopId, tt.shop_name as shopName, " +
        "tt.menu_id as menuId, tt.menu_name as menuName, tt.menu_picture as menuPicture, " +
        "tt.price as price, tt.meal_type as mealType, tt.ticket_type as ticketType, " +
        "tt.ticket_desc as ticketDesc, tt.ticket_detail_desc as ticketDetailDesc, tt.item_id itemId, tt.item_count itemCount, " +
        "tt.created_date as createdDate, tt.modified_date as modifiedDate " +
        "from tb_sales ts, tb_ticket tt " +
        "where tt.user_id = :userId and ts.ticket_id = tt.ticket_id";
    @Query(value = usedQuery, nativeQuery = true)
    List<TicketEntity> findTicketUsed(@Param("userId") Long userId);

    String usedGroupQuery =
        "select tt.order_id as orderId, tt.school_name as schoolName, tt.shop_name as shopName, " +
        "tt.ticket_type as ticketType, tt.meal_type as mealType, " +
        "tt.menu_picture as menuPicture, tt.menu_name as menuName, DATE_FORMAT(tt.created_date,'%Y-%m-%d') as buyDate, " +
        "tt.price as ticketPrice, tt.item_count as totalCount, count(*) as itemCount " +
        "from tb_sales ts, tb_ticket tt " +
        "where tt.user_id = :userId and ts.ticket_id = tt.ticket_id " +
        "group by orderId, schoolName, shopName, ticketType, mealType, menuPicture, menuName, buyDate, ticketPrice, totalCount order by orderId desc" ;
    @Query(value = usedGroupQuery, nativeQuery = true)
    List<TicketGroupView> findTicketUsedGroup(@Param("userId") Long userId);

}
