package com.LMS.LibraryManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.AuthorRepo;
import com.LMS.LibraryManagementSystem.Model.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo repo;

	public int addAuthorDetails(Author author) {
		try {
			repo.save(author);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateAuthorDetails(Author author) {
		try {
			repo.save(author);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int deleteAuthorDetails(int authorid) {
		try {
			repo.deleteById(authorid);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List<Author> viewAuthorList() {
		List<Author> rk = new ArrayList<>();
		try {
			return repo.findAll();
		} catch (Exception e) {
			return rk;
		}
	}

	public Author viewAuthorById(int id) {
		try {
			Optional<Author> author = repo.findById(id);
			if(author.isPresent()) {
				return author.get();				
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public AuthorService(AuthorRepo repo) {
		super();
		this.repo = repo;
	}

}