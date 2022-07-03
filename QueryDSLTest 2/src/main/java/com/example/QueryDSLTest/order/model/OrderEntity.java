package com.haksik.haksikapi.order.model;

import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_order")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class OrderEntity extends BaseTimeEntity {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;

    private Long creditcardId;

    private Long itemId;

    private Long itemCount;

    private Long paidPrice;

    private Long paidPoint;

}
