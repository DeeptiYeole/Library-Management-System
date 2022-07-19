package com.LMS.LibraryManagementSystem.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.UserAddress;

@Repository
public interface UserAddressRepo extends JpaRepository<UserAddress, Integer> {
	Optional<UserAddress> findByUsersUserId(int userId);
}
