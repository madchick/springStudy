package com.example.QueryDSLTest.Post.repository;

import com.example.QueryDSLTest.Post.model.PostBoardEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostBoardQDSLRepository {

    List<PostBoardEntity> findPostBoardAllByBoardIdQDSL(Long boardId);

    public PageImpl<PostBoardEntity> findPostBoardAllByBoardIdQDSLWithPaging(Long boardId, Pageable pageable);

}
