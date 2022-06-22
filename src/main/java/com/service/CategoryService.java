package com.service;

import com.entity.Category;
import com.payload.CategoryDto;
import com.payload.Response;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Response add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepository.save(category);
        return new Response("Saqlandi", true);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category get(Long id) {
        Optional<Category> optionalUser = categoryRepository.findById(id);
        return optionalUser.orElseGet(Category::new);
    }

    public Response update(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty())
            return new Response("Bunday Category topilmadi", false);
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepository.save(category);
        return new Response("Updating", true);
    }


    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}

