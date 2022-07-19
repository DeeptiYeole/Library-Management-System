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

import com.LMS.LibraryManagementSystem.Dao.BooksIssuedRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.BooksIssued;
import com.LMS.LibraryManagementSystem.Service.BooksIssuedService;

@ExtendWith(MockitoExtension.class)
class BooksIssuedTest {
	@Mock
	BooksIssuedRepo repo;

	private BooksIssuedService service;

	@BeforeEach
	void setUp() {
		this.service = new BooksIssuedService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void addIssuedBooksTest() {
		BooksIssued issued = new BooksIssued(11, null, null, null, 10, null);
		service.addIssuedBooks(issued);
		assertEquals(issued.getQuantity(), 10);
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updateIssuedBookDetailsTest() {
		BooksIssued issued = new BooksIssued(10, null, null, null, 11, null);
		try {
			service.updateIssuedBookDetails(issued);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(issued.getQuantity(), 11);
	}

	@Test
	@Order(3)
	@Rollback(false)
	void deleteIssuedBooksTest()  {
		try {
			service.deleteIssuedBooks(10);
		} catch (BookNotFoundException e) {
		e.printStackTrace();
		}
		verify(repo).deleteById(10);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void viewBooksIssuedListTest() {
		service.viewBooksIssuedList();
		verify(repo).findAll();
	}
}
