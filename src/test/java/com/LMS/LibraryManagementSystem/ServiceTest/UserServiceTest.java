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

import com.LMS.LibraryManagementSystem.Dao.UserRepo;
import com.LMS.LibraryManagementSystem.Exceptions.UserNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Users;
import com.LMS.LibraryManagementSystem.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepo repo;

	private UserService service;

	@BeforeEach
	void setUp() {
		this.service = new UserService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void viewAllUsersTest() {
		service.viewAllUsers();
		verify(repo).findAll();
	}

	@Test
	@Order(2)
	@Rollback(false)
	void deleteUserByIdTest() {
		try {
			service.deleteUser(1);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).deleteById(1);
	}

	@Test
	@Order(3)
	@Rollback(false)
	void cancleSubscriptionTest() {
		service.cancleSubscription(5);
		verify(repo).deleteById(5);
	}

	@Test
	@Order(4)
	@Rollback(false)
	void updateUserDetailsTest() {
		Users user = new Users(10, null, "Roshan", null, null, null, null, null, null, null);
		try {
			service.updateUserDetails(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(user.getFirstName(), "Roshan");
	}

	@Test
	@Order(5)
	@Rollback(false)
	void addRegisterTest() {
		Users user = new Users(1, "123@rk", "Roshan", "kharode", "7719068128", "roshan@gmail.com", null, null, null,
				"Active");
		service.register(user);
		assertEquals(user.getEmail(), "roshan@gmail.com");
	}

}
