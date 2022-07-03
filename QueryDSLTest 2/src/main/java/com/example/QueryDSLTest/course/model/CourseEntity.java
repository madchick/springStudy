package com.haksik.haksikapi.course.model;

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
@Table(name="tb_course")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class CourseEntity extends BaseTimeEntity {

    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name="school_id")
    private Long schoolId;

    private String courseName;
    private String courseDesc;

    private Boolean enabled;

}
