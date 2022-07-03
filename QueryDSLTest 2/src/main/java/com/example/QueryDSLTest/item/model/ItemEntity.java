package com.haksik.haksikapi.item.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
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

    private MealType mealType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name="item_id"))
    private Set<ItemMealtypeEntity> mealTypes;

    private String itemDesc;
    private String itemDetailDesc;

    private Boolean enabled;

}
