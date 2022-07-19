package com.LMS.LibraryManagementSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LMS.LibraryManagementSystem.Model.Publishers;

@Repository
public interface PublisherRepo extends JpaRepository<Publishers, Integer> {

}
