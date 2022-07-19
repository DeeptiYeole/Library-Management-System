package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.SuggestedBooks;
import com.LMS.LibraryManagementSystem.Service.SuggestedBooksService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SuggestedBooksController {

	@Autowired
	SuggestedBooksService ser;

//	@GetMapping("/suggested")
//	public List<SuggestedBooks> getSuggestedBooks(){
//		return ser.suggestBooks();
//	}

	@PutMapping("/suggested")
	public int updateSuggestedBooksStatus(@RequestBody SuggestedBooks books) {
		return ser.updateSuggestedBookStatus(books);
	}

	@DeleteMapping("/suggested/{id}")
	public int deleteSuggestedBooksById(@PathVariable int id) throws BookNotFoundException {
		return ser.deleteSuggestedBooks(id);
	}

	@GetMapping("/suggested/{id}")
	public SuggestedBooks getSuiggestedBooksByid(@PathVariable int id) throws BookNotFoundException {
		return ser.viewSuggestedBookDetails(id);
	}

	@GetMapping("/suggested")
	public List<SuggestedBooks> getAllSuggestedBooks() {
		return ser.viewSuggestedBooksList();
	}

}
