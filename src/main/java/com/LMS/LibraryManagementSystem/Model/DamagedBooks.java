package com.LMS.LibraryManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DamagedBooks")
public class DamagedBooks {
	@Id
	@Column
	private int dbookId;

	@OneToOne
	@JoinColumn(name = "Books_Id", referencedColumnName = "bookId")
	private Books books;

	@Column
	private int quantity;

	@Column
	private String description;

	public DamagedBooks() {
		super();
	}

	public DamagedBooks(int dbookId, Books books, int quantity, String description) {
		super();
		this.dbookId = dbookId;
		this.books = books;
		this.quantity = quantity;
		this.description = description;
	}

	public int getDbookId() {
		return dbookId;
	}

	public void setDbookId(int dbookId) {
		this.dbookId = dbookId;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
