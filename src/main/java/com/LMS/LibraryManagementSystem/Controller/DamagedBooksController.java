package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Model.DamagedBooks;
import com.LMS.LibraryManagementSystem.Service.DamegedBooksService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DamagedBooksController {

	@Autowired
	DamegedBooksService ser;

	@PostMapping("/damaged")
	public int addDamagedBooks(@RequestBody Books book) {
		return ser.addDamagedBooks(book);
	}

	@PutMapping("/damaged")
	public int updateDamagedBooks(@RequestBody Books book) {
		return ser.updateDamegedBookDetails(book);
	}

	@GetMapping("/damaged")
	public List<DamagedBooks> getAllDamagedBooks() {
		return ser.viewDamagedBooksList();
	}

	@GetMapping("/damaged/{id}")
	public DamagedBooks damagedBookBy(@PathVariable int id) {
		return ser.viewDamegedBooksById(id);
	}
}
