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

import com.LMS.LibraryManagementSystem.Dao.PublisherRepo;
import com.LMS.LibraryManagementSystem.Exceptions.PublisherNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Publishers;
import com.LMS.LibraryManagementSystem.Service.PublisherService;

@ExtendWith(MockitoExtension.class)
public class PublisherTest {

	@Mock
	PublisherRepo repo;

	private PublisherService service;

	@BeforeEach
	void setUp() {
		this.service = new PublisherService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void addPublisherTest() {
		Publishers publisher = new Publishers(1, "Roshan", "7719068128", "roshan@gmail.com", "Akola", "Akola", "Akola",
				"Maharashtra", 444103);
		service.addPublisher(publisher);
		assertEquals(publisher.getPincode(), 444103);
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updatePublisherTest() {
		Publishers publisher = new Publishers(1, "Roshan", "7719068128", "roshan@gmail.com", "Akola", "Akola", "Akola",
				"Maharashtra", 444103);
		service.addPublisher(publisher);
		assertEquals(publisher.getPublisherName(), "Roshan");
	}

	@Test
	@Order(3)
	@Rollback(false)
	void removePublisherTest() {
		try {
			service.removePublisher(1);
		} catch (PublisherNotFoundException e) {
		
			e.printStackTrace();
		}
		verify(repo).deleteById(1);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void viewPublishersByIdTest() {
		service.viewPublishers(3);
		verify(repo).findById(3);
	}

	@Test
	@Order(5)
	@Rollback(false)
	void viewPublishersTest() {
		service.viewPublishers();
		verify(repo).findAll();
	}
}
