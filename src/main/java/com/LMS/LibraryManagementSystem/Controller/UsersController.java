package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.UserNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Users;
import com.LMS.LibraryManagementSystem.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

	@Autowired
	UserService uservice;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return uservice.viewAllUsers();
	}

	@PostMapping("/users")
	public int saveUsers(@RequestBody Users users) {
		return uservice.register(users);
	}

	@PutMapping("/users")
	public int updateUser(@RequestBody Users users) throws UserNotFoundException {
		return uservice.updateUserDetails(users);
	}

	@DeleteMapping("/users/{id}")
	public int deleteby(@RequestBody int id) throws UserNotFoundException {
		return uservice.deleteUser(id);
	}
}
