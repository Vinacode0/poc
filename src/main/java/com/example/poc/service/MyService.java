package com.example.poc.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.dao.Employee;
import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.repo.MyRepo;

import ch.qos.logback.classic.Logger;

@Service
public class MyService {

	
	@Autowired
	private MyRepo repo;

	public Employee createEmployee(Employee e) {
		Employee newe = repo.save(e);

		return newe;

	}

	public Optional<Employee> getEmployee(Integer id) {
		Optional<Employee> newe = repo.findById(id);

		return newe;

	}

	public Optional<List<Employee>> getAllEmployees() {
		
		return Optional.ofNullable(repo.findAll());
		 
	}

	public Employee updateEmployee(Employee e) {
		Optional<Employee> newe = repo.findById(e.getEid());
		
		if(newe.isEmpty()) {
			throw new ResourceNotFoundException("Employee Not found");
		}
		
		return repo.save(e);
	}

}
