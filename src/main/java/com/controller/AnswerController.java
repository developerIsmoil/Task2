package com.controller;

import com.entity.Answer;
import com.entity.Task;
import com.entity.User;
import com.payload.AnswerDto;
import com.payload.Response;
import com.repository.TaskRepository;
import com.repository.UserRepository;
import com.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @PostMapping
    public Response add(@Valid @RequestBody AnswerDto answeDto) {
        return answerService.add(answeDto);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAll() {
        List<Answer> answerList = answerService.getAll();
        return ResponseEntity.ok(answerList);
    }

    @GetMapping("/{id}")
    public Answer get(@PathVariable Long id) {
        return answerService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody AnswerDto answerDto) {
        return answerService.update(id, answerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        answerService.delete(id);
    }
}
