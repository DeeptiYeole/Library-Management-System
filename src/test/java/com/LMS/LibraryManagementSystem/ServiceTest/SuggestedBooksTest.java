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

import com.LMS.LibraryManagementSystem.Dao.SuggestedBooksRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Model.SuggestedBooks;
import com.LMS.LibraryManagementSystem.Service.SuggestedBooksService;

@ExtendWith(MockitoExtension.class)
public class SuggestedBooksTest {

	@Mock
	private SuggestedBooksRepo repo;

	private SuggestedBooksService service;

	@BeforeEach
	void setUp() {
		this.service = new SuggestedBooksService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void getAllSuggestedBooksTest() {
		service.viewSuggestedBooksList();
		verify(repo).findAll();
	}
	@Test
	@Order(2)
	@Rollback(false)
	void getSuggestedBooksByIdTest() {
		try {
			service.viewSuggestedBookDetails(1);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).findById(1);
	}
	
	@Test
	@Order(3)
	@Rollback(false)
	void deleteSuggestedBooksByIdTest() {
		try {
			service.deleteSuggestedBooks(2);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).deleteById(2);
	}
	
	@Test
	@Order(4)
	@Rollback
	void updateSuggestedBooksTest() {
		SuggestedBooks suggestedBooks = new SuggestedBooks(1,null,"Title",null,null,null,null,null,null);
		service.updateSuggestedBookStatus(suggestedBooks);
		assertEquals(suggestedBooks.getTitle(), "Title" );
	}
}
