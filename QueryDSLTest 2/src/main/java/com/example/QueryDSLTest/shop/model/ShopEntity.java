package com.haksik.haksikapi.shop.model;

import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import com.haksik.haksikapi.menu.model.MenuEntity;
import com.haksik.haksikapi.school.model.SchoolEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_shop")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class ShopEntity extends BaseTimeEntity {

    @Id
    @Column(name="shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Column(name="school_id")
    private Long schoolId;

    private String shopName;

    private String shopLocation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("meal_type ASC")
    @JoinColumn(name = "shop_id")
    private Set<ShopTimeEntity> shopTimes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("meal_type ASC")
    @JoinColumn(name = "shop_id")
    private Set<MenuEntity> menuEntities;

    private String shopHoliday;

    private String menulistUrl;

    private boolean enabled;

}
