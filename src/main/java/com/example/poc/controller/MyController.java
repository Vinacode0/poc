package com.example.poc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.dao.Employee;
import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.service.MyService;

@RestController
@CrossOrigin(origins="http://localhost:3003")
public class MyController {
	
	@Autowired
	MyService myservice;
	
	@PostMapping("/createemployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
		
		Employee newe =	myservice.createEmployee(e);
		return new ResponseEntity<Employee>(newe, HttpStatus.OK);
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		
		Optional<Employee> newe =	myservice.getEmployee(id);
		if(newe.isPresent()) {
			return new ResponseEntity<Employee>(newe.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Employee not found");
		}
		
	}
	
	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		Optional<List<Employee>> newe =	myservice.getAllEmployees();
		if(newe.isPresent()) {
			return new ResponseEntity<>(newe.get(), HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Employees not found");
		}
		
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		
		Employee newe =	myservice.updateEmployee(e);
		
			return new ResponseEntity<>(newe, HttpStatus.OK);
		
		
	}

}
