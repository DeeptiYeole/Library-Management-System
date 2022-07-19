package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksRepo;
import com.LMS.LibraryManagementSystem.Dao.DamagedBooksRepo;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Model.DamagedBooks;

@Service
public class DamegedBooksService {

	@Autowired
	private DamagedBooksRepo repo;

	@Autowired
	private BooksRepo brepo;

	public int addDamagedBooks(Books bookid) {
		try {
			brepo.save(bookid);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateDamegedBookDetails(Books book) {
		try {
			brepo.save(book);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List<DamagedBooks> viewDamagedBooksList() {
		return repo.findAll();
	}

	public DamagedBooks viewDamegedBooksById(int id) {
		Optional<DamagedBooks> dbooks = repo.findById(id);
		if (dbooks.isPresent()) {
			return dbooks.get();
		} else {
			return null;
		}
	}

	public DamegedBooksService(DamagedBooksRepo repo) {
		super();
		this.repo = repo;
	
	}
	
}
