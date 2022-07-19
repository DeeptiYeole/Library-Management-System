package com.LMS.LibraryManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksReturnedRepo;
import com.LMS.LibraryManagementSystem.Model.BooksReturned;

@Service
public class BooksReturnedService {

	@Autowired
	BooksReturnedRepo repo;

	public int returnBook(BooksReturned returned) {
		try {
			repo.save(returned);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	public int updateReturnedBookDetails(BooksReturned booksReturned) {
		try {
			repo.save(booksReturned);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List<BooksReturned> viewReturnedBooksList() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			return null;
		}

	}

	public List<BooksReturned> viewDelayedBooksList() {
		List<BooksReturned> breturned = repo.findAll();
		int limit = 15;
		for (BooksReturned b : breturned) {
			if (b.getDelayed_Days() > limit) {
				return (List<BooksReturned>) b.getUsers();
			}
		}
		return null;
	}

	public BooksReturnedService(BooksReturnedRepo repo) {
		super();
		this.repo = repo;
	}
	

}