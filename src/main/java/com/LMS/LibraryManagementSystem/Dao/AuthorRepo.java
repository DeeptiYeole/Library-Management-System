package com.LMS.LibraryManagementSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
