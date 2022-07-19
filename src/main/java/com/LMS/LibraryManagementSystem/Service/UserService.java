package com.LMS.LibraryManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksReturnedRepo;
import com.LMS.LibraryManagementSystem.Dao.UserRepo;
import com.LMS.LibraryManagementSystem.Exceptions.UserNotFoundException;
import com.LMS.LibraryManagementSystem.Model.BooksReturned;
import com.LMS.LibraryManagementSystem.Model.Users;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private BooksReturnedRepo rrepo;

	public int register(Users user) {
		repo.save(user);
		return 1;
	}

	public Users loginValidate(String username, String password)throws UserNotFoundException {
		List<Users> user = repo.findByFirstName(username);
		for (Users u : user) {
			if (u.getPassword() == password) {
				return user.get(1);
			} else {
			}
		}
		throw new UserNotFoundException(username+"'s Details not Found");
	}

	public void cancleSubscription(int userId) {
		try {
			repo.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int payThePenaltyy(int userId, double amount) {
		List<BooksReturned> b = rrepo.findByUsersUserId(userId);
		int totalPenalty = 0;
		for (BooksReturned m : b) {
			totalPenalty += m.getPenalty();
		}
		if (totalPenalty == 0) {
			return 0;
		}
		{
			return totalPenalty;
		}
	}

	public List<Users> viewAllUsers() {
		return repo.findAll();
	}

	public int updateUserDetails(Users user)throws UserNotFoundException {
		try {
			repo.save(user);
			return 1;
		} catch (Exception e) {
			throw new UserNotFoundException("User not Found");      
    	}
}
	public int deleteUser(int id) throws UserNotFoundException {
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw new UserNotFoundException("User not Found");
		}
	}

	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}
}
