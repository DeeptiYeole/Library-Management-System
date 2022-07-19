package com.LMS.LibraryManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.LibraryManagementSystem.Dao.BooksOrderRepo;
import com.LMS.LibraryManagementSystem.Dao.BooksRepo;
import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Exceptions.OrderNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Model.BooksOrder;

@Service
public class BooksOrderService {
	private static final Logger log = LoggerFactory.getLogger(BooksOrderService.class);
	@Autowired
	BooksOrderRepo repo;

	@Autowired
	BooksRepo brepo;

	public int placeBooksOrder(Books book) throws OrderNotFoundException {
		try {
			brepo.save(book);
			return 1;
		} catch (Exception e) {
			throw new OrderNotFoundException("ordered book does not exist");	
		}
	}

	public int cancleOrder(int orderId) {
		try {
			repo.deleteById(orderId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int updateOrder(BooksOrder order) throws OrderNotFoundException{
		try {
			repo.save(order);
			return 1;
		} catch (Exception e) {
			throw new OrderNotFoundException("Order Book does not exist");
		}
	}

	public List<BooksOrder> viewOrderList() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public BooksOrder viewOrderById(int orderId) throws BookNotFoundException {
		try {
			Optional<BooksOrder> bookbyid = repo.findById(orderId);
			return bookbyid.get();
		} catch (Exception e) {
			throw new BookNotFoundException("BookId:"+orderId+" does not exist");
		}
	}

	public BooksOrderService(BooksOrderRepo repo) {
		super();
		this.repo = repo;

	}
	
}
