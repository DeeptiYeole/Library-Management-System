package com.LMS.LibraryManagementSystem.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
	List<Books> findByTitle(String title);
	List<Books> findBySubject(String subject);
}
