package com.todos.controller;
import com.todos.entity.User;
import com.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
