package com.example.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.poc.dao.Employee;

@Repository
public interface MyRepo extends JpaRepository< Employee,Integer> {

}
