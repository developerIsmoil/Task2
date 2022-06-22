package com.service;

import com.entity.Answer;
import com.entity.Task;
import com.entity.User;
import com.payload.AnswerDto;
import com.payload.Response;
import com.repository.AnswerRepository;
import com.repository.TaskRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    public Response add(AnswerDto answerDto) {
        Optional<User> optionalUser = userRepository.findById(answerDto.getUser_id());
        if (optionalUser.isEmpty())
            return new Response("Bunday User Yo'q", false);
        Optional<Task> optionalTask = taskRepository.findById(answerDto.getTask_id());
        if (optionalTask.isEmpty())
            return new Response("Bunday Task Yo'q", false);
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.set_correct(answerDto.is_correct());
        answer.setTaskId(optionalTask.get());
        answer.setUserId(optionalUser.get());
        answerRepository.save(answer);
        return new Response("Saqlandi", true);
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public Answer get(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        return optionalAnswer.orElseGet(Answer::new);
    }

    public Response update(Long id, AnswerDto answerDto) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isEmpty())
            return new Response("Bunday Answer topilmadi", false);
        Optional<User> optionalUser = userRepository.findById(answerDto.getUser_id());
        if (optionalUser.isEmpty())
            return new Response("Bunday User Yo'q", false);
        Optional<Task> optionalTask = taskRepository.findById(answerDto.getTask_id());
        if (optionalTask.isEmpty())
            return new Response("Bunday Task Yo'q", false);
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.set_correct(answerDto.is_correct());
        answer.setTaskId(optionalTask.get());
        answer.setUserId(optionalUser.get());
        answerRepository.save(answer);
        return new Response("Updating", true);
    }

    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
