package com.pawa.pawatask.service;

import com.pawa.pawatask.domain.Priority;
import com.pawa.pawatask.domain.Task;
import com.pawa.pawatask.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    List<Priority> getAllPriority();

    List<TaskDTO> getAllTask();

    TaskDTO editTask(TaskDTO task);

    TaskDTO getTaskById(String id);

    Task delete(String id);
}
