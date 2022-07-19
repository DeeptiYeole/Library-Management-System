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

import com.LMS.LibraryManagementSystem.Dao.AuthorRepo;
import com.LMS.LibraryManagementSystem.Model.Author;
import com.LMS.LibraryManagementSystem.Service.AuthorService;

@ExtendWith(MockitoExtension.class)
class AuthorTest {
	@Mock
	AuthorRepo repo;

	private AuthorService service;

	@BeforeEach
	void setUp() {
		this.service = new AuthorService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void addAuthorDetailsTest() {
		Author author = new Author(1, "Roshan", "Kharode", "roshan@gmail.com", "7719068128");
		service.addAuthorDetails(author);
		assertEquals(author.getContactno(), "7719068128");
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updateAuthorDetailsTest() {
		Author author = new Author(2, "Roshan", "Kharode", "roshan@gmail.com", "7719068128");
		service.addAuthorDetails(author);
		assertEquals(author.getLastName(), "Kharode");
	}

	@Test
	@Order(3)
	@Rollback(false)
	void deleteAuthorDetailsTest() {
		service.deleteAuthorDetails(2);
		verify(repo).deleteById(2);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void viewAuthorListTest() {
		service.viewAuthorList();
		verify(repo).findAll();
	}

	@Test
	@Order(5)
	@Rollback(false)
	void viewAuthorByIdTest() {
		service.viewAuthorById(3);
		verify(repo).findById(3);
	}
}
