package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.AddressNotFoundException;
import com.LMS.LibraryManagementSystem.Model.UserAddress;
import com.LMS.LibraryManagementSystem.Service.UserAddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserAddressController {
	
	private static final Logger log = LoggerFactory.getLogger(UserAddressController.class);
	@Autowired
	UserAddressService addressservice;

	@PostMapping("/users/address")
	public int addUserAddress(@RequestBody UserAddress address) {
		return addressservice.addUserAddress(address);
	}

	@PutMapping("/users/address")
	public int updateUserAddress(@RequestBody UserAddress address) throws AddressNotFoundException {
		log.info("user Address Recived");
		return addressservice.updateAddress(address);
	}

	@DeleteMapping("/users/address/{addressid}")
	public int deleteUserAddres(@PathVariable int addressid) throws AddressNotFoundException {
		return addressservice.deleteUserAddress(addressid);
	}

	@GetMapping("/users/address")
	public List<UserAddress> viewAllUserAddress() {
		return addressservice.viewUserAddress();
	}

	@GetMapping("/users/address/{id}")
	public UserAddress viewaddressByUserId(@PathVariable int id) throws AddressNotFoundException {
		return addressservice.viewAddressByUserId(id);
	}
}
