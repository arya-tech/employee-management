package com.em.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.em.entites.Employee;

@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, Serializable> {
	
	public Employee findByEmpId(int empId);
	

}
