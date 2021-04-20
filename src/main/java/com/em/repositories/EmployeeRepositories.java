package com.em.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.em.entites.Employee;
import com.em.model.EmployeeModel;

@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, Serializable> {
	
	@Query("select e.empId, e.firstName, e.lastName,e.address,e.city,e.dob,e.mobileNo from Employee e")
	public List<EmployeeModel> fetchAllEmpDetails();
	
	public Employee findByEmpId(int empId);
	

}
