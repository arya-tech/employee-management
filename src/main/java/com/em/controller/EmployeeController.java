package com.em.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.model.EmployeeModel;
import com.em.service.EmpManagementService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmpManagementService empManagementService;
	
	@PostMapping(value = "/addEmp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmp(@RequestBody EmployeeModel employeeModel){
		String empStatus = empManagementService.saveEmp(employeeModel);
		return new ResponseEntity<String>(empStatus, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllEmp",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeModel>> getAllEmpDetails(){
		String msg=null;
		List<EmployeeModel> empModelList=new ArrayList<>();
		empModelList=empManagementService.fetchAllEmpDetails();
		for(EmployeeModel empModel:empModelList) {
			System.out.println(empModel);
		}
		return new ResponseEntity<List<EmployeeModel>>(empModelList,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEmp/{empId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") int empId,@RequestBody EmployeeModel empModel){
		String msg=empManagementService.updateEmp(empId, empModel);
		if(msg==null) {
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId")int empId){
		String msg = empManagementService.deleteEmployee(empId);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	

}
