package com.nearsoft.training.springtraining.repository

import com.nearsoft.training.springtraining.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends CrudRepository<User, Integer> {

}