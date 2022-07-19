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

import com.LMS.LibraryManagementSystem.Exceptions.PublisherNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Publishers;
import com.LMS.LibraryManagementSystem.Service.PublisherService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PublisherController {

	@Autowired
	PublisherService ser;

	@PostMapping("/publisher")
	public int addPlisherData(@RequestBody Publishers publisher) {
		return ser.addPublisher(publisher);
	}

	@PutMapping("/publisher")
	public int updatePublisherDetails(@RequestBody Publishers publishers) {
		return ser.updatePublisher(publishers);
	}

	@DeleteMapping("/publisher/{id}")
	public int removePublisherByid(@PathVariable int id) throws PublisherNotFoundException {
		return ser.removePublisher(id);
	}

	@GetMapping("/publisher")
	public List<Publishers> getAllPOublisherDetails() {
		return ser.viewPublishers();
	}
}
