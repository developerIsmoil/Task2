package com.controller;

import com.entity.Task;
import com.payload.Response;
import com.payload.TaskDto;
import com.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public Response add(@Valid @RequestBody TaskDto taskDto) {
        return taskService.add(taskDto);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        List<Task> taskList = taskService.getAll();
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable Long id) {
        return taskService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody TaskDto taskDto) {
        return taskService.update(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}

