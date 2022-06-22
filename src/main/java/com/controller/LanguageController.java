package com.controller;

import com.entity.Language;
import com.payload.LanguageDto;
import com.payload.Response;
import com.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping
    public Response add(@Valid @RequestBody LanguageDto languageDto) {
        return languageService.add(languageDto);
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAll() {
        List<Language> languageList = languageService.getAll();
        return ResponseEntity.ok(languageList);
    }

    @GetMapping("/{id}")
    public Language get(@PathVariable Long id) {
        return languageService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody LanguageDto languageDto) {
        return languageService.update(id, languageDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        languageService.delete(id);
    }
}
