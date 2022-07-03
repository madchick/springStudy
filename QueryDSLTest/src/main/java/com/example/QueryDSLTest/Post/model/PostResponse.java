package com.example.QueryDSLTest.Post.model;

import com.example.QueryDSLTest.User.model.UserEntity;
import com.example.QueryDSLTest._comm_.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PostResponse extends BaseResponse {

    public PostResponse() {
        super();
        this.setPath("/post");
    }

    private List<PostEntity> postEntities;
    private Page<PostEntity> postEntitiesWithPaging;

    private List<PostBoardEntity> postBoardEntities;
    private Page<PostBoardEntity> postBoardEntitiesWithPaging;

}
