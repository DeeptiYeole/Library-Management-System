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

import com.LMS.LibraryManagementSystem.Model.Author;
import com.LMS.LibraryManagementSystem.Service.AuthorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthoController {

	@Autowired
	AuthorService ser;

	@PostMapping("/author")
	public int addAuthor(@RequestBody Author author) {
		return ser.addAuthorDetails(author);
	}

	@PutMapping("/author")
	public int updateAuthorDetails(@RequestBody Author author) {
		return ser.updateAuthorDetails(author);
	}

	@DeleteMapping("/author/{authorid}")
	public int deleteAuthorByid(@PathVariable int authorid) {
		return ser.deleteAuthorDetails(authorid);
	}

	@GetMapping("/author")
	public List<Author> getAllAuthor() {
		return ser.viewAuthorList();
	}

	@GetMapping("/author/{id}")
	public Author getAuthorByid(@PathVariable int id) {
		return ser.viewAuthorById(id);
	}
}
