package com.LMS.LibraryManagementSystem.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.BooksReturned;

@Repository
@Transactional
public interface BooksReturnedRepo extends JpaRepository<BooksReturned, Integer> {
       List<BooksReturned> findByUsersUserId(int userid);
       
}
