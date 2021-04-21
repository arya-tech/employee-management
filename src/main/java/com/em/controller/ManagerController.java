package com.em.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.em.model.ManagerModel;
import com.em.service.EmpManagementService;
import com.em.form.ManagerLoginForm;
@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private EmpManagementService empManagementService;
	
	@GetMapping(value = "/loadForm")
	public String loadForm(Model model) {
		model.addAttribute("manager", new ManagerModel());
		return "manager-reg-form";// return the empty form to the user
	}
	
	
	@PostMapping(value = "/registration",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addManager(@RequestBody ManagerModel managerModel){
		String msg=null;
		boolean isEmailUnique = empManagementService.isEmailUnique(managerModel.getEmail());
		if(isEmailUnique==true) {
			 msg = empManagementService.saveManager(managerModel);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}else {
			msg="email-id already exist try another one"; // throwing an exception
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST); 
		}
		
	}
	
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("managerLogin", new ManagerLoginForm());
		return "home";
	}
	
	
	@GetMapping("/loginCheck/{emailId}/{password}")
	public ResponseEntity<String> loginCheck(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
		boolean isAuthenticated=false;
		String msg=null;
		isAuthenticated=empManagementService.isAuthenticated(emailId, password);
		if(isAuthenticated==true) {
			msg="login success!!";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		msg="username/password invalid";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
	}

}
