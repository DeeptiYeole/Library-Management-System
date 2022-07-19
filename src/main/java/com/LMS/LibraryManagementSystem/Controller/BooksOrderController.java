package com.LMS.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.LibraryManagementSystem.Exceptions.BookNotFoundException;
import com.LMS.LibraryManagementSystem.Exceptions.OrderNotFoundException;
import com.LMS.LibraryManagementSystem.Model.Books;
import com.LMS.LibraryManagementSystem.Model.BooksOrder;
import com.LMS.LibraryManagementSystem.Service.BooksOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BooksOrderController {

	@Autowired
	BooksOrderService ser;

	@PostMapping("/booksOrder")
	public int placeBooks(@RequestBody Books book) throws OrderNotFoundException {
		return ser.placeBooksOrder(book);
	}

	@DeleteMapping("/booksOrder/{id}")
	public int cancleOrderById(@PathVariable int id) {
		return ser.cancleOrder(id);
	}

	@PutMapping("/booksOrder")
	public int updateOrders(@RequestBody BooksOrder book) throws OrderNotFoundException {
		return ser.updateOrder(book);
	}

	@GetMapping("/bookorder")
	public List<BooksOrder> getOrderList() {
		return ser.viewOrderList();
	}

	@GetMapping("/bookorder/{id}")
	public BooksOrder getOderById(@PathVariable int id) throws BookNotFoundException {
		return ser.viewOrderById(id);
	}
}