package com.pawa.pawatask.service.impl;

import com.pawa.pawatask.domain.Comment;
import com.pawa.pawatask.dto.CommentDTO;
import com.pawa.pawatask.repository.CommentRepository;
import com.pawa.pawatask.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setCreateDate(new Date());
        comment.setCreatedBy(commentDTO.getCreatedBy());
        comment.setTaskId(commentDTO.getTaskId());
        return commentRepository.save(comment);
    }

    @Override
    public void editComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentByTaskId(String taskId) {
        return commentRepository.findAllByTaskIdOrderByCreateDateAsc(taskId);
    }

    @Override
    public Comment save(Comment comment) {
        comment.setCreateDate(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteMany(String id) {
        List<Comment> comments = commentRepository.findAllByTaskId(id);
        commentRepository.deleteAll(comments);
    }
}
