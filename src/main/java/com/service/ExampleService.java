package com.service;

import com.entity.Example;
import com.entity.Task;
import com.payload.ExampleDto;
import com.payload.Response;
import com.repository.ExampleRepository;
import com.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {
    @Autowired
    ExampleRepository exampleRepository;
    @Autowired
    TaskRepository taskRepository;

    public Response add(ExampleDto exampleDto) {
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTask_id());
        if (optionalTask.isEmpty())
            return new Response("Bunday Task mavjud emas", false);
        Example example = new Example();
        example.setText(exampleDto.getText());
        example.setTaskId(optionalTask.get());
        exampleRepository.save(example);
        return new Response("Saqlandi", true);
    }

    public List<Example> getAll() {
        return exampleRepository.findAll();
    }

    public Example get(Long id) {
        Optional<Example> optionalExample = exampleRepository.findById(id);
        return optionalExample.orElseGet(Example::new);
    }

    public Response update(Long id, ExampleDto exampleDto) {
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTask_id());
        if (optionalTask.isEmpty())
            return new Response("Bunday Task mavjud emas", false);
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isEmpty())
            return new Response("Bunday Example mavjud emas", false);
        Example example = new Example();
        example.setText(exampleDto.getText());
        example.setTaskId(optionalTask.get());
        exampleRepository.save(example);
        return new Response("Updating", true);
    }

    public void delete(Long id) {
        exampleRepository.deleteById(id);
    }
}
