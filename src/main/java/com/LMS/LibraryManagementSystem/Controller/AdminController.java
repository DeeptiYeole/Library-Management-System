package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.enterWrongCredintals;
import com.LMS.LibraryManagementSystem.Model.Admin;
import com.LMS.LibraryManagementSystem.Service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("/admin")
	public Optional<Admin> fetchAdmin(@RequestBody String username,  String password) throws enterWrongCredintals {
		return service.ValidateAdmin(username, password);
	}

}
