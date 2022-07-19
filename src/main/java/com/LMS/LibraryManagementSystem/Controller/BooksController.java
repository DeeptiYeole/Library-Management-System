package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Service.BooksService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/books")
	public int addBooks(@RequestBody Books book) {
		return booksService.addBook(book);
	}

	@PutMapping("/books")
	public int updateBooks(@RequestBody Books book) {
		return booksService.updateBookDetails(book);
	}

	@DeleteMapping("/books/{id}")
	public int deletebooksbyid(@PathVariable int id) throws BookNotFoundException {
		return booksService.removeBook(id);
	}

	@GetMapping("/books/{title}")
	public List<Books> getBooksByTitle(@PathVariable String title) throws BookNotFoundException {
		return booksService.searchBookByTitle(title);
	}

	@GetMapping("/books/{subject}")
	public List<Books> getBooksBySubject(@PathVariable String subject) throws BookNotFoundException {
		return booksService.searchBookBySubject(subject);
	}

	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return booksService.viewAllBooks();
	}

}