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

import com.LMS.LibraryManagementSystem.Dao.ReaderRepo;
import com.LMS.LibraryManagementSystem.Exceptions.ReaderNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Reader;
import com.LMS.LibraryManagementSystem.Service.ReaderService;

@ExtendWith(MockitoExtension.class)
public class ReaderTest {
	@Mock
	ReaderRepo repo;

	private ReaderService service;

	@BeforeEach
	void setUp() {
		this.service = new ReaderService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void registerTest() {
		Reader reader = new Reader(11, "771906@Rk", "Roshan", "kharode", "77190682128", "Roshan@gmail.com");
		service.register(reader);
		assertEquals(reader.getFirstName(), "Roshan");
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updateReaderTest() {
		Reader reader = new Reader(12, "771906@Rk", "Roshan", "kharode", "77190682128", "Roshan@gmail.com");
		service.updateReaderDetails(reader);
		assertEquals(reader.getPassword(), "771906@Rk");
	}

	@Test
	@Order(3)
	@Rollback(false)
	void deleteReaderByIdTest() {
		try {
			service.deleteReader(3);
		} catch (ReaderNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).deleteById(3);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void viewReaderByIdTest() {
		service.viewReaderById(7);
		verify(repo).findById(7);
	}

	@Test
	@Order(5)
	@Rollback(false)
	void viewReaderListTest() {
		service.viewReadersList();
		verify(repo).findAll();
	}
}
