package com.haksik.haksikapi.shop.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
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
@Table(name="tb_shop_time")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class ShopTimeEntity extends BaseTimeEntity {

    @Id
    @Column(name="shoptime_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoptimeId;

    private MealType mealType;

    private String startTime;
    private String endTime;

    private boolean enabled;
}
