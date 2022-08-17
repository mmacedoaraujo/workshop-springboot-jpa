package com.mmacedoaraujo.workshopspringbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmacedoaraujo.workshopspringbootjpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
