package com.controller;

import com.entity.User;
import com.payload.Response;
import com.payload.UserDto;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserContoller {
    @Autowired
    UserService userService;

    @PostMapping
    public Response add(@Valid @RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = userService.getAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public Response edit(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
