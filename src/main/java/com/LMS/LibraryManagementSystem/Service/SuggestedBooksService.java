package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.SuggestedBooksRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Model.SuggestedBooks;

@Service
public class SuggestedBooksService {

	@Autowired
	private SuggestedBooksRepo repo;

	public int suggestBooks(List<Books> bookList) {
		
		return 0;
	}

	public int updateSuggestedBookStatus(SuggestedBooks book) {
		try {
			repo.save(book);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int deleteSuggestedBooks(int id)  throws BookNotFoundException{
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw new BookNotFoundException("Book Id "+id+ " not available");
		}
	}

	public SuggestedBooks viewSuggestedBookDetails(int id)throws BookNotFoundException {
		Optional<SuggestedBooks> sbooks = repo.findById(id);
		if (sbooks.isPresent()) {
			return sbooks.get();
		} else {
			throw new BookNotFoundException("Suggested Book Id "+id+ " not available");
		}
	}

	public List<SuggestedBooks> viewSuggestedBooksList() {
		return repo.findAll();
	}

	public SuggestedBooksService(SuggestedBooksRepo repo) {
		super();
		this.repo = repo;
	}

	
}
