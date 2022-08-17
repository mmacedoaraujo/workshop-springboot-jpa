package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
