package com.nearsoft.training.springtraining.service

import com.nearsoft.training.springtraining.model.User
import com.nearsoft.training.springtraining.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.persistence.EntityExistsException
import javax.persistence.EntityNotFoundException
import java.time.ZoneId
import java.time.ZonedDateTime

@Service
class UserService {
    @Autowired
    UserRepository userRepository;

    User getUser(int id){
        return userRepository.findById(id).orElseThrow({new EntityNotFoundException("No user found with id = " + id)})
    }

    List<User> getAllUsers(){
        return userRepository.findAll()
    }

    User addUser(User user){
        User createdUser = userRepository.findById(user.getId()).orElse(null)
        if (createdUser != null) {
            throw new EntityExistsException("User found with id = " + user.getId())
        }
        user.setCreatedAt(ZonedDateTime.now(ZoneId.systemDefault()))
        return userRepository.save(user)
    }

    User updateUser(int id, User user){
        User oldUser = userRepository.findById(id).orElse(null)
        if (oldUser == null){
            throw new EntityNotFoundException("No user found with id = " + id)
        }
        oldUser.setPassword(user.getPassword())
        oldUser.setEmailAddress(user.getEmailAddress())
        oldUser.setActive(user.getActive())
        return userRepository.save(oldUser)
    }

    void deleteUser(int id){
        User oldUser = userRepository.findById(id).orElse(null)
        if (oldUser == null){
            throw new EntityNotFoundException("No user found with id = " + id)
        }
        userRepository.deleteById(id)
    }
}
