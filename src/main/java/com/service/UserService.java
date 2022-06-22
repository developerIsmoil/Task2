package com.service;

import com.entity.User;
import com.payload.Response;
import com.payload.UserDto;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Response add(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return new Response("Saqlandi", true);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public Response update(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return new Response("Bunday User topilmadi", false);
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return new Response("Updating", true);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}