package com.service;

import com.entity.Language;
import com.entity.Task;
import com.payload.Response;
import com.payload.TaskDto;
import com.repository.LanguageRepository;
import com.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    LanguageRepository languageRepository;

    public Response add(TaskDto taskDto) {
        Optional<Language> optionalLanguage = languageRepository.findById(taskDto.getLenguage_id());
        if (optionalLanguage.isEmpty())
            return new Response("Bunday language topilmadi", false);
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setText(taskDto.getText());
        task.setSolution(taskDto.getSolution());
        task.setHint(taskDto.getHint());
        task.setMethod(taskDto.getMethod());
        task.setHas_star(taskDto.isHas_star());
        task.setLanguageId(optionalLanguage.get());
        taskRepository.save(task);
        return new Response("Saqlandi", true);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task get(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.orElseGet(Task::new);
    }

    public Response update(Long id, TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
            return new Response("Bunday Task topilmadi", false);
        Optional<Language> optionalLanguage = languageRepository.findById(taskDto.getLenguage_id());
        if (optionalLanguage.isEmpty())
            return new Response("Bunday Language topilmadi", false);
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setText(taskDto.getText());
        task.setSolution(taskDto.getSolution());
        task.setHint(taskDto.getHint());
        task.setMethod(taskDto.getMethod());
        task.setHas_star(taskDto.isHas_star());
        task.setLanguageId(optionalLanguage.get());
        taskRepository.save(task);
        return new Response("Updating", true);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
