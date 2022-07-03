package com.haksik.haksikapi.menu.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.GopublicType;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.SalesStatusType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_menu")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class MenuEntity extends BaseTimeEntity {

    @Id
    @Column(name="menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name="shop_id")
    private Long shopId;

    private String menuName;

    private String menuDesc;
    private String menuDetailDesc;

    private MealType mealType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id", foreignKey = @ForeignKey(name="menu_id"))
    private Set<MenuMealtypeEntity> mealTypes;

    private Long menuPrice;

    private String menuPicture;

    private TicketType ticketType;

    private SalesStatusType salesStatusType;

    private GopublicType gopublicType;

    private LocalDateTime salesStartDate;
    private LocalDateTime salesStopDate;

    private Boolean enabled;

}
