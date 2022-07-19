package com.LMS.LibraryManagementSystem.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

//	Optional<Users> findByUserId(String userid);
	List<Users> findByFirstName(String username);

}
