package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
