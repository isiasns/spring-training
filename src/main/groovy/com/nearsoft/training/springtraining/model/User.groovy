package com.nearsoft.training.springtraining.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class User {
    @Id
    Integer id
    String username
    String password
    String emailAddress
    Date createdAt
    Boolean active = true
}
