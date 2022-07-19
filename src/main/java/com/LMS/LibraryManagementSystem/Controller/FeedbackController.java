package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Model.Feedback;
import com.LMS.LibraryManagementSystem.Service.FeedbackService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

	@Autowired
	FeedbackService ser;

	@PostMapping("/feedback/{id}")
	public int writefeedback(@PathVariable int id) {
		return ser.writeFeedback(id);
	}

	@PutMapping("/feedback")
	public int updateFeedback(@RequestBody Feedback feedback) {
		return ser.updateFeedback(feedback);
	}

	@GetMapping("/feedback")
	public List<Feedback> getAllFeedback() {
		return ser.viewFeedbackList();
	}

	@GetMapping("/feedback/{id}")
	public Feedback getFeedbcakId(@PathVariable int id) {
		return ser.viewFeedbackByUser(id);
	}
}
