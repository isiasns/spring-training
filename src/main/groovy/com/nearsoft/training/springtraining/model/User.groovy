package com.nearsoft.training.springtraining.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull
import java.time.ZonedDateTime

@Entity
class User {
    @Id
    Integer id
    @Column(unique = true, updatable = false)
    @NotNull(message = "Field username is required ")
    String username
    @NotNull(message = "Field password is required")
    String password
    @NotNull(message = "Field emailAddress is required")
    String emailAddress
    ZonedDateTime createdAt
    Boolean active = true
}
