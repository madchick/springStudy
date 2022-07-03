package com.haksik.haksikapi.courseprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.haksik.haksikapi._comm_.model.BaseTimeEntity;
import com.haksik.haksikapi.course.model.CourseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_course_price")
@IdClass(CoursePriceKey.class)
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class CoursePriceEntity extends BaseTimeEntity {

    @Id
    @Column(name="menu_id")
    @JsonIgnore
    private Long menuId;

    @Id
    @Column(name="course_id", updatable=false)
    private Long courseId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable=false, updatable=false)
    private CourseEntity courseEntity;

    private Long coursePrice;

    private Boolean enabled;

}
