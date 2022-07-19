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

import com.LMS.LibraryManagementSystem.Dao.DamagedBooksRepo;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Service.DamegedBooksService;

@ExtendWith(MockitoExtension.class)
class DamagedBooksTest {

	@Mock
	private DamagedBooksRepo repo;

	private DamegedBooksService service;

	@BeforeEach
	void setUp() {
		this.service = new DamegedBooksService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void addDamagedBooksTest() {
		Books books = new Books(10, null, null, null, null, 2022, null, 0, null, null, null);
		service.addDamagedBooks(books);
		assertEquals(books.getPublished_year(), 2022);
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updateDamegedBookDetailsTest() {
		Books books = new Books(10, null, null, null, null, 2023, null, 0, null, null, null);
		service.addDamagedBooks(books);
		assertEquals(books.getPublished_year(), 2023);
	}

	@Test
	@Order(3)
	@Rollback(false)
	void viewDamagedBooksListTest() {
		service.viewDamagedBooksList();
		verify(repo).findAll();
	}

	@Test
	@Order(4)
	@Rollback(false)
	void viewDamegedBooksByIdTest() {
		service.viewDamegedBooksById(111);
		verify(repo).findById(111);
	}

}
