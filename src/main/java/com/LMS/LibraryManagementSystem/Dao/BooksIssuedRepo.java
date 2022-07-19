package com.LMS.LibraryManagementSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.BooksIssued;

@Repository
public interface BooksIssuedRepo extends JpaRepository<BooksIssued, Integer> {

}
