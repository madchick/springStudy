package com.example.QueryDSLTest.User.model;

import com.example.QueryDSLTest._comm_.codeenum.codedata.UserType;
import com.example.QueryDSLTest._comm_.model.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tb_user")
@EqualsAndHashCode(callSuper=false)
@DynamicInsert
@DynamicUpdate
public class UserEntity extends BaseTimeEntity {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    @JsonIgnore
    private String password;

    private String name;

    private UserType userType;

    private Boolean enabled;

}
