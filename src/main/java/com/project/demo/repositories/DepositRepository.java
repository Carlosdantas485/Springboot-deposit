package com.project.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
