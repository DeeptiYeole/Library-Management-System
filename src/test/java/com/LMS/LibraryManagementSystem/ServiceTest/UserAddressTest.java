package com.LMS.LibraryManagementSystem.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.LMS.LibraryManagementSystem.Dao.UserAddressRepo;
import com.LMS.LibraryManagementSystem.Exceptions.AddressNotFoundException;
import com.LMS.LibraryManagementSystem.Model.UserAddress;
import com.LMS.LibraryManagementSystem.Service.UserAddressService;

@ExtendWith(MockitoExtension.class)
public class UserAddressTest {

	@Mock
	UserAddressRepo repo;

	private UserAddressService service;

	@BeforeEach
	void setUp() {
		this.service = new UserAddressService(this.repo);
	}

	@Test
	@Order(1)
	@Rollback(false)
	void addUserAddressTest() {
		UserAddress address = new UserAddress();
		address.setCity("Akola");
		assertThat(address.getCity()).isEqualTo("Akola");
	}

	@Test
	@Order(2)
	@Rollback(false)
	void updateAddressTest() {
		UserAddress getAddress = new UserAddress(11, "akola", "akola", "Maharashtra", 444103, null);
		service.addUserAddress(getAddress);
		assertEquals(getAddress.getCity(), "akola");
	}

	@Test
	@Order(3)
	@Rollback
	void deleteUserAddressTest() {
		try {
			service.deleteUserAddress(5);
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).deleteById(5);
	}

	@Test
	@Order(4)
	@Rollback
	void getUserByIdTest() {
		try {
			service.viewAddressByUserId(2);
		} catch (AddressNotFoundException e) {
			e.printStackTrace();
		}
		verify(repo).findById(2);
	}

	@Test
	@Order(5)
	@Rollback
	void getAllUserTest() {
		service.viewUserAddress();
		verify(repo).findAll();
	}

}
