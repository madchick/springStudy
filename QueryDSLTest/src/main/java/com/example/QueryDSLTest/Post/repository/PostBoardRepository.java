package com.example.QueryDSLTest.Post.repository;

import com.example.QueryDSLTest.Post.model.PostBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostBoardRepository extends JpaRepository<PostBoardEntity, Long>, PostBoardQDSLRepository {

    List<PostBoardEntity> findPostBoardAllByBoardId(Long boardId);

}
