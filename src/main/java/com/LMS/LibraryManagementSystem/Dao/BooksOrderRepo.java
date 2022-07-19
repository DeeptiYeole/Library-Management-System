package com.LMS.LibraryManagementSystem.Dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.BooksOrder;

@Repository
@Transactional
public interface BooksOrderRepo extends JpaRepository<BooksOrder,Integer > {


}
