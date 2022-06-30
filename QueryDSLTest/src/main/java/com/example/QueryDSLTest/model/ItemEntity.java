package com.example.QueryDSLTest.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_item")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class ItemEntity extends BaseTimeEntity {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Long shopId;

    private Long menuId;
    private String menuPicture;

    private String itemName;

    private Long itemBundleCount;

    private Long itemPrice;

    private String itemDesc;
    private String itemDetailDesc;

    private Boolean enabled;

}
