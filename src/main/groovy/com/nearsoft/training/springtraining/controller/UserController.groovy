package com.nearsoft.training.springtraining.controller

import com.nearsoft.training.springtraining.model.User
import com.nearsoft.training.springtraining.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/users", produces = "application/json")
    ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers())
    }

    @GetMapping(path = "/user/{id}", produces = "application/json")
    ResponseEntity<User> getUser(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(userService.getUser(id))
    }

    @PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
    ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user))
    }

    @PutMapping(path = "/user/{id}", consumes = "application/json", produces = "application/json")
    ResponseEntity<User> updateUser(@PathVariable(name = "id") int id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user))
    }

    @DeleteMapping(path = "/user/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable(name = "id") int id){
        userService.deleteUser(id)
    }
}
