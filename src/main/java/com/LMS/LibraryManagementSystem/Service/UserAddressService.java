package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.UserAddressRepo;
import com.LMS.LibraryManagementSystem.Dao.UserRepo;
import com.LMS.LibraryManagementSystem.Exceptions.AddressNotFoundException;
import com.LMS.LibraryManagementSystem.Model.UserAddress;

@Service
public class UserAddressService {

	private static final Logger log = LoggerFactory.getLogger(UserAddressService.class);
	@Autowired
	private UserAddressRepo repo;
	@Autowired
	private UserRepo urepo;

	public int addUserAddress(UserAddress address) {
		Optional<UserAddress> a = repo.findByUsersUserId(address.getAddressId());
		if(a.isPresent()) {
			repo.save(address);
			return 1;
		}
		return 0;
	}

	public int updateAddress(UserAddress address) throws AddressNotFoundException {
		try {
			repo.save(address);
			log.info("Addres updated");
			return 1;
		} catch (Exception e) {
			throw new AddressNotFoundException("User Address not Found");  
		}
	}

	public int deleteUserAddress(int addressId)throws AddressNotFoundException {
		try {
			repo.deleteById(addressId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public UserAddress viewAddressByUserId(int userid)throws AddressNotFoundException {
		Optional<UserAddress> status = repo.findById(userid);
		if (status.isEmpty()) {
			throw new AddressNotFoundException("User Address not Found");   
		} else {
			return status.get();
		}
	}

	public List<UserAddress> viewUserAddress() {
		return repo.findAll();

	}

	public UserAddressService(UserAddressRepo repo) {
		super();
		this.repo = repo;
	}
	
}
