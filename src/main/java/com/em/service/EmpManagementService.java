package com.em.service;

import java.util.List;

import com.em.model.EmployeeModel;
import com.em.model.ManagerModel;

public interface EmpManagementService {
	
	public String saveManager(ManagerModel managerModel);
	
	public boolean isEmailUnique(String emailId);
	
	public boolean isAuthenticated(String emailId, String password);
	
	public String saveEmp(EmployeeModel employeeModel);
	
	public List<EmployeeModel> fetchAllEmpDetails();
	
	public String updateEmp(int empId, EmployeeModel employee);
	
	public String deleteEmployee(int empId);

}
