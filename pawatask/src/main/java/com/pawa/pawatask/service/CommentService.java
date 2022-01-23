package com.pawa.pawatask.service;

import com.pawa.pawatask.domain.Comment;
import com.pawa.pawatask.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    Comment createComment(CommentDTO commentDTO);

    List<Comment> getAllCommentByTaskId(String taskId);

    void editComment(Comment comment);

    Comment save(Comment comment);

    void deleteMany(String id);
}
