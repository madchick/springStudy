package com.example.QueryDSLTest.Post.repository;

import com.example.QueryDSLTest.Post.model.PostBoardEntity;

import java.util.List;

public interface PostBoardQDSLRepository {

    List<PostBoardEntity> findPostBoardAllByBoardIdQDSL(Long boardId);

}
