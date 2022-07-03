package com.example.QueryDSLTest.User.model;

import com.example.QueryDSLTest._comm_.codeenum.codedata.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String email;

    private String password;

    private String name;

    private UserType userType;

    private Boolean enabled;

}
