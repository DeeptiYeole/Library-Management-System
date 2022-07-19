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

import com.LMS.LibraryManagementSystem.Exceptions.ReaderNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Reader;
import com.LMS.LibraryManagementSystem.Service.ReaderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReaderController {

	@Autowired
	ReaderService rservice;

	@PostMapping("/reader")
	public int registerReader(@RequestBody Reader reader) {
		return rservice.register(reader);
	}

	@PutMapping("/reader")
	public int updateReaderDetrails(@RequestBody Reader reader) {
		return rservice.updateReaderDetails(reader);
	}

	@DeleteMapping("/reader/{id}")
	public int deleteReader(@PathVariable int id) throws ReaderNotFoundException {
		return rservice.deleteReader(id);
	}

	@GetMapping("/reader")
	public List<Reader> viewReaderList() {
		return rservice.viewReadersList();
	}

	@GetMapping("/reader/{id}")
	public Reader viewReaderbyid(@PathVariable int id) {
		return rservice.viewReaderById(id);
	}

	@PostMapping("/reader/login/{readerid}/{password}")
	public Reader loginvalidate(@PathVariable String readerid, String password) {
		return null;
	}

}
