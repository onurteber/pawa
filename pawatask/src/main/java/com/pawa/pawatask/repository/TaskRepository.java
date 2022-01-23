package com.pawa.pawatask.repository;

import com.pawa.pawatask.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
