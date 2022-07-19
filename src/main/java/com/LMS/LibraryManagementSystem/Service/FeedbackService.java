package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.FeedbackRepo;
import com.LMS.LibraryManagementSystem.Model.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepo repo;

	public int writeFeedback(int userid) {
//		Optional<Feedback> feedback = repo.findByUsersUserId(userid);
//		if(feedback.isPresent()) {
//			repo.save(null)
//		}
//		repo.saveUserId(userid);
		return 0;
	}

	public int updateFeedback(Feedback feedback) {
		try {
			repo.save(feedback);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Feedback viewFeedbackByUser(int userid) {
		Optional<Feedback> feedback = repo.findByUsersUserId(userid);
		if (feedback.isPresent()) {
			return feedback.get();
		} else {
			return null;
		}
	}

	public List<Feedback> viewFeedbackList() {
		return repo.findAll();
	}

	public FeedbackService(FeedbackRepo repo) {
		super();
		this.repo = repo;
	}
	
}