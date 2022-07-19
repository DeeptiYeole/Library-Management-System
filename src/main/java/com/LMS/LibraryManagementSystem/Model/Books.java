package com.LMS.LibraryManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Books {

	@Id
	@Column
	private int bookId;

	@Column
	private String title;

	@Column
	private String subject;

	@Column
	private String author;

	@Column
	private String publisher;

	@Column
	private int published_year;

	@Column
	private String isbn_code;

	@Column
	private int quantity;

	@Column
	private String shelf_details;

	@ManyToOne
	private BooksReturned booksReturned;

	@ManyToOne
	private BooksIssued booksIssued;
	
	
	public Books() {
		super();
	}

	public Books(int bookId, String title, String subject, String author, String publisher, int published_year,
			String isbn_code, int quantity, String shelf_details, BooksReturned booksReturned,
			BooksIssued booksIssued) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publisher = publisher;
		this.published_year = published_year;
		this.isbn_code = isbn_code;
		this.quantity = quantity;
		this.shelf_details = shelf_details;
		this.booksReturned = booksReturned;
		this.booksIssued = booksIssued;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public String getIsbn_code() {
		return isbn_code;
	}

	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShelf_details() {
		return shelf_details;
	}

	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}

	public BooksReturned getBooksReturned() {
		return booksReturned;
	}

	public void setBooksReturned(BooksReturned booksReturned) {
		this.booksReturned = booksReturned;
	}

	public BooksIssued getBooksIssued() {
		return booksIssued;
	}

	public void setBooksIssued(BooksIssued booksIssued) {
		this.booksIssued = booksIssued;
	}

}
