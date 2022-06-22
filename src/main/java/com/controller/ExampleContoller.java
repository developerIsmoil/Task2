package com.controller;

import com.entity.Category;
import com.entity.Example;
import com.payload.CategoryDto;
import com.payload.ExampleDto;
import com.payload.Response;
import com.service.CategoryService;
import com.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/example")
public class ExampleContoller {
    @Autowired
    ExampleService exampleService;

    @PostMapping
    public Response add(@Valid @RequestBody ExampleDto exampleDto) {
        return exampleService.add(exampleDto);
    }

    @GetMapping
    public ResponseEntity<List<Example>> getAll() {
        List<Example> exampleList = exampleService.getAll();
        return ResponseEntity.ok(exampleList);
    }

    @GetMapping("/{id}")
    public Example get(@PathVariable Long id) {
        return exampleService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody ExampleDto exampleDto) {
        return exampleService.update(id, exampleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exampleService.delete(id);
    }
}
