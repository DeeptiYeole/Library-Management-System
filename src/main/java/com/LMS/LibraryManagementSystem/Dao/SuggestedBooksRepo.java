package com.LMS.LibraryManagementSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.SuggestedBooks;

@Repository
public interface SuggestedBooksRepo extends JpaRepository<SuggestedBooks, Integer> {

}
