package com.haksik.haksikapi.school.model;

import com.haksik.haksikapi._comm_.codeenum.codedata.CalcClassType;
import com.haksik.haksikapi._comm_.codeenum.codedata.CalcType;
import com.haksik.haksikapi._comm_.codeenum.codedata.DistrictType;
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
@Table(name="tb_school")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class SchoolEntity extends BaseTimeEntity {

    @Id
    @Column(name="school_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private String schoolName;

    private DistrictType schoolAddress;

    private Long userId;
    private String userAccount;

    private Long calcCycle;

    private Double calcFee;

    private CalcClassType calcClass;

    private CalcType calcType;

    private String personName;

    private String personPhoneNumber;

    private String schoolPhoneNumber;

    private Boolean enabled;

}
