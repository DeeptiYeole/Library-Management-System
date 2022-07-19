package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.PublisherRepo;
import com.LMS.LibraryManagementSystem.Exceptions.PublisherNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Publishers;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepo repo;

	public int addPublisher(Publishers publishers) {
		try {
			repo.save(publishers);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updatePublisher(Publishers publishers) {
		try {
			repo.save(publishers);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int removePublisher(int id) throws PublisherNotFoundException{
		try {
			repo.deleteById(id);
			return 1;
		} catch (Exception e) {
			throw new PublisherNotFoundException("Publisher does not exist");	
		}
	}

	public Publishers viewPublishers(int id) {
		Optional<Publishers> publisher = repo.findById(id);
		if (publisher.isPresent()) {
			return publisher.get();
		}
		return null;

	}

	public List<Publishers> viewPublishers() {
		return repo.findAll();
	}

	public PublisherService(PublisherRepo repo) {
		super();
		this.repo = repo;
	}

}
