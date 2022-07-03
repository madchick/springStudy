package com.haksik.haksikapi.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
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
@Table(name="tb_menu_mealtype")
@IdClass(MenuMealtypeEntity.class)
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class MenuMealtypeEntity extends BaseTimeEntity implements Serializable {

    @Id
    @Column(name="menu_id")
    @JsonIgnore
    private Long menuId;

    @Id
    private MealType mealType;

}
