package com.example.QueryDSLTest.Post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequest {

    private Long userId;

    private String postTitle;

    private String postContent;

    private Boolean enabled;

}
