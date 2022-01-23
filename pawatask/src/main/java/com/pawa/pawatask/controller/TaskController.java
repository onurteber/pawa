package com.pawa.pawatask.controller;

import com.pawa.pawatask.domain.Priority;
import com.pawa.pawatask.domain.Task;
import com.pawa.pawatask.dto.TaskDTO;
import com.pawa.pawatask.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pawatask/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<TaskDTO> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable String id){
        return taskService.getTaskById(id);
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping()
    public ResponseEntity<TaskDTO> editTask(@RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.editTask(task));
    }

    @GetMapping("/getAllPriority")
    public ResponseEntity<List<Priority>> getAllPriority() {
        return ResponseEntity.ok(taskService.getAllPriority());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Task> delete(@PathVariable String id){
        return ResponseEntity.ok(taskService.delete(id));
    }
}
