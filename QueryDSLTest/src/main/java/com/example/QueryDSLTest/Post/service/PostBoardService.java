package com.example.QueryDSLTest.Post.service;

import com.example.QueryDSLTest.Post.model.PostBoardEntity;
import com.example.QueryDSLTest.Post.repository.PostBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostBoardService {

    @Autowired
    private PostBoardRepository postBoardRepository;

    public List<PostBoardEntity> findPostBoardAllByBoardId(Long boardId) {
        return postBoardRepository.findPostBoardAllByBoardId(boardId);
    }

    public List<PostBoardEntity> findPostBoardAllByBoardId2(Long boardId) {
        return postBoardRepository.findPostBoardAllByBoardIdQDSL(boardId);
    }

    public Page<PostBoardEntity> findPostBoardAllByBoardIdQDSLWithPaging(Long boardId, Pageable pageable) {
        return postBoardRepository.findPostBoardAllByBoardIdQDSLWithPaging(boardId, pageable);
    }

}
