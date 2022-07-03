package com.example.QueryDSLTest.Post.controller;

import com.example.QueryDSLTest.Post.model.PostBoardEntity;
import com.example.QueryDSLTest.Post.model.PostResponse;
import com.example.QueryDSLTest.Post.service.PostBoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostBoardService postBoardService;

    @GetMapping("/browse1")
    public ResponseEntity<PostResponse> findPostBoardAllByBoardId(@RequestParam Long boardId) {
        List<PostBoardEntity> postBoardEntities = this.postBoardService.findPostBoardAllByBoardId(boardId);

        PostResponse postResponse = new PostResponse();
        postResponse.setStatus("200");
        postResponse.setError("success");
        postResponse.setPostBoardEntities(postBoardEntities);

        return ResponseEntity.ok(postResponse);
    }

    @GetMapping("/browse2")
    public ResponseEntity<PostResponse> findPostBoardAllByBoardId2(@RequestParam Long boardId) {
        List<PostBoardEntity> postBoardEntities = this.postBoardService.findPostBoardAllByBoardId2(boardId);

        PostResponse postResponse = new PostResponse();
        postResponse.setStatus("200");
        postResponse.setError("success");
        postResponse.setPostBoardEntities(postBoardEntities);

        return ResponseEntity.ok(postResponse);
    }

    @GetMapping("/browse3")
    public ResponseEntity<PostResponse> findPostBoardAllByBoardId2(@RequestParam Long boardId, Pageable pageable) {
        Page<PostBoardEntity> postBoardEntities = this.postBoardService.findPostBoardAllByBoardIdQDSLWithPaging(boardId,pageable);

        PostResponse postResponse = new PostResponse();
        postResponse.setStatus("200");
        postResponse.setError("success");
        postResponse.setPostBoardEntitiesWithPaging(postBoardEntities);

        return ResponseEntity.ok(postResponse);
    }

}
