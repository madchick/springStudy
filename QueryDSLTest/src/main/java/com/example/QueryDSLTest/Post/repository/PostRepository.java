package com.example.QueryDSLTest.Post.repository;

import com.example.QueryDSLTest.Post.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
