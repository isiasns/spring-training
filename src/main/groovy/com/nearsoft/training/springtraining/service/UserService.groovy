package com.nearsoft.training.springtraining.service

import com.nearsoft.training.springtraining.model.User
import com.nearsoft.training.springtraining.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.text.SimpleDateFormat

@Service
class UserService {
    @Autowired
    UserRepository userRepository;

    User getUser(int id){
        return userRepository.findById(id).orElse(null)
    }

    List<User> getAllUsers(){
        return userRepository.findAll()
    }

    User addUser(User user){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy")
        String dateAsString = sdf.format(new Date())
        Date dateFromString = sdf.parse(dateAsString)
        user.setCreatedAt(dateFromString)
        return userRepository.save(user)
    }

    User updateUser(int id, User user){
        User oldUser = getUser(id)
        oldUser.setUsername(user.getUsername())
        oldUser.setPassword(user.getPassword())
        oldUser.setEmailAddress(user.getEmailAddress())
        oldUser.setActive(user.getActive())
        return userRepository.save(oldUser)
    }

    void deleteUser(int id){
        userRepository.deleteById(id)
    }
}
