package com.pawa.pawatask.service.impl;

import com.pawa.pawatask.domain.Comment;
import com.pawa.pawatask.domain.Priority;
import com.pawa.pawatask.domain.Task;
import com.pawa.pawatask.dto.CommentDTO;
import com.pawa.pawatask.dto.TaskDTO;
import com.pawa.pawatask.exception.TaskNotFoundException;
import com.pawa.pawatask.repository.TaskRepository;
import com.pawa.pawatask.service.CommentService;
import com.pawa.pawatask.service.TaskService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final CommentService commentService;

    public TaskServiceImpl(TaskRepository taskRepository, CommentService commentService) {
        this.taskRepository = taskRepository;
        this.commentService = commentService;
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        Task task = new Task();
        task.setCreateDate(new Date());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDay().concat("/").concat(taskDTO.getMonth()).concat("/").concat(taskDTO.getYear()));
        task.setPriority(taskDTO.getPriority());
        task.setTitle(taskDTO.getTitle());
        task.setUpdateDate(new Date());
        task.setCreatedBy(taskDTO.getCreatedBy());
        task.setLastUpdatedBy(taskDTO.getLastUpdatedBy());

        Task savedTask = taskRepository.save(task);

        taskDTO.setId(savedTask.getId());

        if(StringUtils.isNotEmpty(taskDTO.getComment())) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCreatedBy(taskDTO.getCreatedBy());
            commentDTO.setContent(taskDTO.getComment());
            commentDTO.setTaskId(savedTask.getId());
            commentService.createComment(commentDTO);
        }

        return taskDTO;
    }

    @Override
    public TaskDTO editTask(TaskDTO taskDTO) {

        Task task = taskRepository.findById(taskDTO.getId()).orElseThrow(() -> new TaskNotFoundException());

        Task editedTask = taskDTOToTask(task, taskDTO);


        Task save = taskRepository.save(editedTask);

        if(taskDTO.getComment() != null){
            Comment comment = new Comment();
            comment.setContent(taskDTO.getComment());
            comment.setCreateDate(new Date());
            comment.setTaskId(save.getId());
            comment.setCreatedBy(save.getCreatedBy());

            commentService.editComment(comment);
        }
        return taskDTO;
    }

    @Override
    public List<Priority> getAllPriority() {
        return Arrays.asList(Priority.values());
    }

    @Override
    public List<TaskDTO> getAllTask() {
        return taskRepository.findAll().stream().map(task -> taskToTaskDTO(task)).collect(Collectors.toList());

    }

    @Override
    public TaskDTO getTaskById(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        return taskToTaskDTO(task);
    }

    @Override
    public Task delete(String id) {
        commentService.deleteMany(id);
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        taskRepository.delete(task);
        return task;
    }

    private TaskDTO taskToTaskDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setCreatedBy(task.getCreatedBy());
        dto.setLastUpdatedBy(task.getLastUpdatedBy());
        String[] dueDate = task.getDueDate().split("/");
        dto.setDay(String.valueOf(dueDate[0]));
        dto.setMonth(String.valueOf(dueDate[1]));
        dto.setYear(String.valueOf(dueDate[2]));
        return dto;
    }

    private Date stringDateToLongDate(TaskDTO taskDTO) {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return f.parse(taskDTO.getDay() +"-" + taskDTO.getMonth() + "-" + taskDTO.getYear());
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    private Task taskDTOToTask(Task task, TaskDTO taskDTO) {
        task.setLastUpdatedBy(taskDTO.getLastUpdatedBy());
        task.setTitle(taskDTO.getTitle());
        task.setPriority(taskDTO.getPriority());
        task.setDescription(taskDTO.getDescription());
        task.setUpdateDate(new Date());
        task.setDueDate(taskDTO.getDay().concat("/").concat(taskDTO.getMonth()).concat("/").concat(taskDTO.getYear()));
        return task;
    }

}
