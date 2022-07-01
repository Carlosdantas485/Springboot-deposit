package com.project.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Deposit;
import com.project.demo.services.DepositService;

@RestController
@RequestMapping(value = "/deposits")
public class DepositResource {

	@Autowired
	private DepositService service;


	@GetMapping
	public ResponseEntity<List> findAll() {
		List<Deposit> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Deposit> findById(@PathVariable Long id) {
		Deposit obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	

}
