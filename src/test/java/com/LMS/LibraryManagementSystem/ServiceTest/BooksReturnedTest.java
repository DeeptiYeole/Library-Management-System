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

import com.LMS.LibraryManagementSystem.Dao.BooksReturnedRepo;
import com.LMS.LibraryManagementSystem.Model.BooksReturned;
import com.LMS.LibraryManagementSystem.Service.BooksReturnedService;

@ExtendWith(MockitoExtension.class)
class BooksReturnedTest {

	@Mock
	private BooksReturnedRepo repo;

	private BooksReturnedService service;

	@BeforeEach
	void setUp() {
		this.service = new BooksReturnedService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void viewReturnedBooksListTest() {
		service.viewReturnedBooksList();
		verify(repo).findAll();
	}

	@Test
	@Order(2)
	@Rollback(false)
	void viewDelayedBooksListTest() {
		service.viewDelayedBooksList();
		verify(repo).findAll();
	}

	@Test
	@Order(3)
	@Rollback(false)
	void returnBookTest() {
		BooksReturned booksReturend = new BooksReturned(1, null, null, null, 1, 10.54, "pending");
		service.returnBook(booksReturend);
		assertEquals(booksReturend.getPenalty(), 10.54);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void updateReturnedBookDetailsTest() {
		BooksReturned booksReturend = new BooksReturned(1, null, null, null, 1, 10.70, "pending");
		service.returnBook(booksReturend);
		assertEquals(booksReturend.getPenalty(), 10.70);
	}
}
