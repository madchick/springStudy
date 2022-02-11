package com.example.todoserver.controller;

import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.model.TodoResponse;
import com.example.todoserver.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest todoRequest) {
        System.out.println("CREATE");

        if (ObjectUtils.isEmpty(todoRequest.getTitle()))
            return ResponseEntity.badRequest().build();
        if (ObjectUtils.isEmpty(todoRequest.getOrder()))
            todoRequest.setOrder(0L);
        if (ObjectUtils.isEmpty(todoRequest.getCompleted()))
            todoRequest.setCompleted(false);

        TodoEntity result = this.service.add(todoRequest);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        System.out.println("READ ONE");

        TodoEntity result = this.service.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        System.out.println("READ ALL");

        List<TodoEntity> list = this.service.searchAll();
        List<TodoResponse> response = list.stream().map(TodoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        System.out.println("UPDATE");

        TodoEntity result = this.service.updateById(id, todoRequest);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        System.out.println("DELETE");

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("DELETE ALL");

        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }

}
