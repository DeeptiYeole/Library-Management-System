package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.BooksIssued;
import com.LMS.LibraryManagementSystem.Service.BooksIssuedService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BooksIssuedController {

	@Autowired
	BooksIssuedService ser;

	@PostMapping("/Boosks/booksIssued")
	public int addIssuedBooks(@RequestBody BooksIssued booksIssued) {
		return ser.addIssuedBooks(booksIssued);
	}

	@PutMapping("/Boosks/booksIssued")
	public int updateBooksIssued(@RequestBody BooksIssued booksIssued) throws BookNotFoundException {
		return ser.updateIssuedBookDetails(booksIssued);
	}

	@DeleteMapping("/Boosks/booksIssued/{id}")
	public int deleteIssuedBooksByid(@PathVariable int id) throws BookNotFoundException {
		return ser.deleteIssuedBooks(id);
	}

	@GetMapping("/Boosks/booksIssued")
	public List<BooksIssued> getIssuedBooks() {
		return ser.viewBooksIssuedList();
	}
}
