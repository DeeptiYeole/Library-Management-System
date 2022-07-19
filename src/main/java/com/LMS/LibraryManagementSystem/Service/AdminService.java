package com.LMS.LibraryManagementSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.AdminRepo;
import com.LMS.LibraryManagementSystem.Exceptions.enterWrongCredintals;
import com.LMS.LibraryManagementSystem.Model.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminRepo repo;

	public Optional<Admin> ValidateAdmin(String firstname, String password) throws enterWrongCredintals {
		Optional<Admin> admin = repo.findByFirstNameAndPassword(firstname, password);
		if (admin.isPresent()) {
			return admin;
		} else {
			throw new enterWrongCredintals("Please write correct credintals");
		}
	}
}
