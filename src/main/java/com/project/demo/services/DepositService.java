package com.project.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entities.Deposit;
import com.project.demo.repositories.DepositRepository;

@Service
public class DepositService {
	
	@Autowired
	private DepositRepository repository;

	public List<Deposit> findAll() {
		return repository.findAll();
	}

	public Deposit findById(Long id) {
		Optional<Deposit> obj = repository.findById(id);
		return obj.get();
	}
	
	public Deposit insert(Deposit obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
