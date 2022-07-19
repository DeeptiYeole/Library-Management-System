package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.ReaderRepo;
import com.LMS.LibraryManagementSystem.Exceptions.ReaderNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Reader;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepo repo;

	public int register(Reader reader) {
		try {
			repo.save(reader);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	public int updateReaderDetails(Reader reader) {
		try {
			repo.save(reader);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int deleteReader(int id) throws ReaderNotFoundException {
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw new ReaderNotFoundException("Reader does not exist");		
		}
	}

	public List<Reader> viewReadersList() {
		return repo.findAll();
	}

	public Reader viewReaderById(int id) {
		Optional<Reader> reader = repo.findById(id);
		if (reader.isPresent()) {
		return 	reader.get();
		}
		return null;
	}

	public Reader loginValidate(String readerid, String password) {
		return null;
	}

	public ReaderService(ReaderRepo repo) {
		super();
		this.repo = repo;
	}

	
}
