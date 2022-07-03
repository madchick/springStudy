package com.haksik.haksikapi.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import com.haksik.haksikapi.menu.model.MenuMealtypeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_item_mealtype")
@IdClass(ItemMealtypeEntity.class)
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class ItemMealtypeEntity extends BaseTimeEntity implements Serializable {

    @Id
    @Column(name="item_id")
    @JsonIgnore
    private Long itemId;

    @Id
    private MealType mealType;

}
