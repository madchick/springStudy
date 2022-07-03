package com.haksik.haksikapi.department.model;

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
@Table(name="tb_department")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class DepartmentEntity extends BaseTimeEntity {

    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private Long schoolId;

    private String departmentName;
    private String departmentDesc;

    private Boolean enabled;

}
