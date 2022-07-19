package com.LMS.LibraryManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;

@Service
public class BooksService {

	@Autowired
	private BooksRepo repo;

	public int addBook(Books book) {
		try {
			repo.save(book);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateBookDetails(Books book) {
		try {
			repo.save(book);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int removeBook(int bookId) throws BookNotFoundException{
		try {
			repo.deleteById(bookId);
			return 1;
		} catch (Exception e) {
        	throw new BookNotFoundException("Books Not Found");
		}
	}

	public List<Books> searchBookByTitle(String keyword)throws BookNotFoundException  {
		List<Books> books = repo.findByTitle(keyword);
		try {
			return books;
		} catch (Exception e) {
			throw new BookNotFoundException("Book Title: "+keyword+" does not exist");
		}
	}
	
	public List<Books> searchBookBySubject(String keyword)  throws BookNotFoundException {
		List<Books> books = repo.findBySubject(keyword);
		try {
			return books;
		} catch (Exception e) {
			throw new BookNotFoundException("Book Subject: "+keyword+" does not exist"); 
		}
	}
	public List<Books> viewAllBooks(){
		try {
			return repo.findAll();			
		} catch (Exception e) {
			return null;
		}
	}

	public BooksService(BooksRepo repo) {
		super();
		this.repo = repo;
	}
	
}
