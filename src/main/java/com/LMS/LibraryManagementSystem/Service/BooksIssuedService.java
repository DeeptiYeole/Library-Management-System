package com.LMS.LibraryManagementSystem.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksIssuedRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.BooksIssued;

@Service
public class BooksIssuedService {

	@Autowired
	private BooksIssuedRepo repo;

	public int addIssuedBooks(BooksIssued issued) {
		try {
			repo.save(issued);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateIssuedBookDetails(BooksIssued booksIssued)  throws BookNotFoundException {
		try {
			repo.save(booksIssued);
			return 1;
		} catch (Exception e) {
			throw new BookNotFoundException("Book does not exist");	
		}
	}

	public int deleteIssuedBooks(int bookid) throws BookNotFoundException  {
		try {
			repo.deleteById(bookid);
			return 1;
		} catch (Exception e) {
			throw new BookNotFoundException("Book does not exist");
		}
	}

	public List<BooksIssued> viewBooksIssuedList() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	public BooksIssuedService(BooksIssuedRepo repo) {
		super();
		this.repo = repo;
	}

}