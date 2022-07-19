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

import com.LMS.LibraryManagementSystem.Dao.BooksRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Service.BooksService;

@ExtendWith(MockitoExtension.class)
class BooksTest {

	@Mock
	private BooksRepo repo;

	private BooksService service;

	@BeforeEach
	void setUp() {
		this.service = new BooksService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void viewAllBooksTest() {
		service.viewAllBooks();
		verify(repo).findAll();
	}

	@Test
	@Order(2)
	@Rollback(false)
	void searchBookBySubjectTest() throws BookNotFoundException {
		service.searchBookBySubject("test");
		verify(repo).findBySubject("test");
	}

	@Test
	@Order(3)
	@Rollback(false)
	void searchBookByTitleTest() throws BookNotFoundException {
		service.searchBookByTitle("test1");
		verify(repo).findByTitle("test1");
	}

	@Test
	@Order(4)
	@Rollback(false)
	void removeBookTest()  {
		try {
			service.removeBook(11);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).deleteById(11);
	}

	@Test
	@Order(5)
	@Rollback(false)
	void addBookTest() {
		Books book = new Books(11, "test", "test", "test", "roshan", 2022, "111", 11, "hardcoded", null, null);
		service.addBook(book);
		assertEquals(book.getPublished_year(), 2022);
	}

	@Test
	@Order(6)
	@Rollback(false)
	void updateBookDetailsTest() {
		Books book = new Books(11, "test", "test", "test", "roshan", 2024, "111", 11, "hardcoded", null, null);
		service.updateBookDetails(book);
		assertEquals(book.getPublished_year(), 2024);
	}

}
