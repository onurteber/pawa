package com.pawa.pawatask.repository;

import com.pawa.pawatask.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllByTaskIdOrderByCreateDateAsc(String userId);
    List<Comment> findAllByTaskId(String userId);

}
