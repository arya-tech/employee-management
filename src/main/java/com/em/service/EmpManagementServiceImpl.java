package com.em.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.em.entites.Employee;
import com.em.entites.Manager;
import com.em.model.EmployeeModel;
import com.em.model.ManagerModel;
import com.em.repositories.EmployeeRepositories;
import com.em.repositories.ManagerRepositories;

@Service
public class EmpManagementServiceImpl implements EmpManagementService {
	
	@Autowired
	private ManagerRepositories managerRepo;
	
	@Autowired
	private EmployeeRepositories empRepo;
	
	@Override
	@Transactional(readOnly = false)
	public String saveManager(ManagerModel managerModel) {
		Manager manager=new Manager();
		String msg=null;
		
			BeanUtils.copyProperties(managerModel, manager);
			Manager savedManager = managerRepo.save(manager);
			if(savedManager!=null) {
				msg="manager added successfully";
			}else {
				msg="failed to save manager info";
			}
		
		return msg;
	}
	
	@Override
	public boolean isEmailUnique(String emailId) {
		Manager manager = managerRepo.findByEmail(emailId);
		if(manager==null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isAuthenticated(String emailId, String password) {
		if(emailId==null && emailId.equals("")&& password==null && password.equals("")) {
			return false;// throwing an exception 
		}
		Manager manager = managerRepo.findByEmail(emailId);
		if(manager!=null) {
			if(manager.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional(readOnly = false)
	public String saveEmp(EmployeeModel employeeModel) {
		String msg=null;
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeModel, employee);
		Employee savedEmp = empRepo.save(employee);
		if(savedEmp!=null) {
			return msg="Employee added successfully";
		}
		return msg="failed to add successfully";
	}
	
	@Override
	public List<EmployeeModel> fetchAllEmpDetails() {
		List<EmployeeModel> empModelList=new ArrayList<>();
		List<Employee> empDetails=new ArrayList<>();
		empDetails = empRepo.findAll();
		for(Employee emp:empDetails) {
			Employee ee=new Employee();
			System.out.println(ee);
		}
		BeanUtils.copyProperties(empDetails, empModelList);
		return empModelList;
			
	}
	
	@Transactional(readOnly = false)
	public String updateEmp(int empId, EmployeeModel employee) {
		String msg=null;
		Employee emp=empRepo.findByEmpId(empId);
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setCity(employee.getCity());
		emp.setAddress(employee.getAddress());
		emp.setDob(employee.getDob());
		emp.setMobileNo(employee.getMobileNo());
		Employee emp1=empRepo.save(emp);
		if(emp1!=null) {
		return msg="record updated successfully!";
		}else {
			msg="failed to update the record";
		}
		return msg;
	}

	@Override
	@Transactional(readOnly = true)
	public String deleteEmployee(int empId) {
		String msg=null;
		empRepo.deleteById(empId);
		msg=empId+" deleted record successfully";
		return msg;
	}
	
	
}
