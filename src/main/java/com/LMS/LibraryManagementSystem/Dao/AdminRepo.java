package com.LMS.LibraryManagementSystem.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
Optional<Admin> findByFirstNameAndPassword(String firstname ,String password);
}
