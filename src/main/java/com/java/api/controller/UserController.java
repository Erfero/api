package com.java.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.java.api.model.User;
import com.java.api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
          return userService.getUserById(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
          return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
          return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
      public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
      }
}
