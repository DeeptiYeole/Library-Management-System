package com.LMS.LibraryManagementSystem.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books_Order")
public class BooksOrder {

	@Id
	@Column
	private int orderId;

	@OneToOne
	@JoinColumn(name = "Books_Id" , referencedColumnName = "bookId")
	private Books books;

	@OneToOne
	@JoinColumn(name = "Publisher_id",referencedColumnName = "publishedrId")
	private Publishers publishers;

	@Column
	private int quantity;

	@Column
	private Date orderDate;

	@Column
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Publishers getPublishers() {
		return publishers;
	}

	public void setPublishers(Publishers publishers) {
		this.publishers = publishers;
	}

}
