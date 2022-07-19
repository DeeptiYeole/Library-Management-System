package com.LMS.LibraryManagementSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.DamagedBooks;

@Repository
public interface DamagedBooksRepo extends JpaRepository<DamagedBooks, Integer> {

}
