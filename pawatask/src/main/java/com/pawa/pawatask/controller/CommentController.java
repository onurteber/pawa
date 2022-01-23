package com.pawa.pawatask.controller;

import com.pawa.pawatask.domain.Comment;
import com.pawa.pawatask.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pawatask/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public List<Comment> getAllCommentByTaskId(@PathVariable String id) {
        return commentService.getAllCommentByTaskId(id);
    }

    @PostMapping()
    public ResponseEntity<Comment> save(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.save(comment));
    }

}
