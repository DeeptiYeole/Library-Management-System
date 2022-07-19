package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Model.BooksReturned;
import com.LMS.LibraryManagementSystem.Service.BooksReturnedService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BooksreturnedController {

	@Autowired
	BooksReturnedService ser;

	@PostMapping("/books/returned")
	public int addReturnedBooks(@RequestBody BooksReturned booksReturned) {
		return ser.returnBook(booksReturned);
	}

	@PutMapping("/books/returned")
	public int updateReturnedBooks(@RequestBody BooksReturned booksReturned) {
		return ser.updateReturnedBookDetails(booksReturned);
	}

	@GetMapping("/books/returned")
	public List<BooksReturned> getReturnedBooksList() {
		return ser.viewReturnedBooksList();
	}

	@GetMapping("/books/returned/delayed")
	public List<BooksReturned> getDelayedBooksList() {
		return ser.viewDelayedBooksList();
	}
}
