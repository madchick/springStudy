package com.example.QueryDSLTest.User.model;

import com.example.QueryDSLTest._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class UserResponse extends BaseResponse {

    public UserResponse() {
        super();
        this.setPath("/user");
    }

    private List<UserEntity> userEntities;
    private Page<UserEntity> userEntitiesWithPaging;

}
