package com.controller;

import com.entity.Category;
import com.payload.CategoryDto;
import com.payload.Response;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryContoller {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Response add(@Valid @RequestBody CategoryDto categoryDto) {
        return categoryService.add(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categoryList = categoryService.getAll();
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}

