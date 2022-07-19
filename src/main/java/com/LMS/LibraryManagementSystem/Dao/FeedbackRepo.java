package com.LMS.LibraryManagementSystem.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	Optional<Feedback> findByUsersUserId(int userid);

}
