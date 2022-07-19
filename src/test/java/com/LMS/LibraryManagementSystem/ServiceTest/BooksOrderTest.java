package com.LMS.LibraryManagementSystem.ServiceTest;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.LMS.LibraryManagementSystem.Dao.BooksOrderRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Service.BooksOrderService;

@ExtendWith(MockitoExtension.class)
class BooksOrderTest {
	@Mock
	private BooksOrderRepo repo;

	private BooksOrderService service;

	@BeforeEach
	void setUp() {
		this.service = new BooksOrderService(this.repo);
	}

	@Test
	@Order(2)
	@Rollback(false)
	void cancleOrderTest() {
		service.cancleOrder(11);
		verify(repo).deleteById(11);

	}
	@Test
	@Order(4)
	@Rollback(false)
	void viewOrderListTest() {
		service.viewOrderList();
		verify(repo).findAll();
	}

	@Test
	@Order(5)
	@Rollback(false)
	void viewOrderByIdTest()  {
		try {
			service.viewOrderById(5);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).findById(5);
	}
}
