package com.LMS.LibraryManagementSystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.LMS.LibraryManagementSystem.Dao.FeedbackRepo;
import com.LMS.LibraryManagementSystem.Model.Feedback;
import com.LMS.LibraryManagementSystem.Service.FeedbackService;

@ExtendWith(MockitoExtension.class)
class FeedbackTest {

	@Mock
	FeedbackRepo repo;

	private FeedbackService service;

	@BeforeEach
	void setUp() {
		this.service = new FeedbackService(this.repo);
	}
	
	@Test
	@Order(1)
	@Rollback(false)
	void viewFeedbackListTest() {
		service.viewFeedbackList();
		verify(repo).findAll();
	}

	@Test
	@Order(2)
	@Rollback(false)
	void viewFeedbackByUserTest() {
		service.viewFeedbackByUser(2);
		verify(repo).findById(2);
	}
	
	@Test
	@Order(3)
	@Rollback(false)
	void updateFeedbackTest() {
		Feedback feedback = new Feedback(10,null,null,"Goos","5","Very Good");
		service.updateFeedback(feedback);
		assertEquals(feedback.getRating(), "5");
	}
	
}
