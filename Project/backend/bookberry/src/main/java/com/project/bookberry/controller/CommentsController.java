package com.project.bookberry.controller;

import com.project.bookberry.entity.Comments;
import com.project.bookberry.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comments>> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(commentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Comments> create(@RequestBody Comments comments) {
        return ResponseEntity.ok(commentService.saveOrUpdate(comments));
    }

    @PutMapping
    public ResponseEntity<Comments> update(@RequestBody Comments comments) {
        return ResponseEntity.ok(commentService.saveOrUpdate(comments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
