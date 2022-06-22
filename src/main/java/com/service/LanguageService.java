package com.service;

import com.entity.Language;
import com.payload.LanguageDto;
import com.payload.Response;
import com.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public Response add(LanguageDto languageDto) {
        Language language = new Language();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new Response("Saqlandi", true);
    }

    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    public Language get(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        return optionalLanguage.orElseGet(Language::new);
    }

    public Response update(Long id, LanguageDto languageDto) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isEmpty())
            return new Response("Bunday Language topilmadi", false);
        Language language = new Language();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new Response("Updating", true);
    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }
}
