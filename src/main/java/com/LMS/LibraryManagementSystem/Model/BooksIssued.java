package com.LMS.LibraryManagementSystem.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BooksIssued")
public class BooksIssued {

	@Id
	@Column
	private int issueId;

	@OneToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "userId", insertable = false, updatable = false)
	private Users users;

	@OneToMany(mappedBy = "booksIssued")
	private List<Books> books;

	@Column
	private Date issueDate;
	@Column
	private int quantity;

	@Column
	private Date dueDate;

	
	public BooksIssued() {
		super();
	}

	public BooksIssued(int issueId, Users users, List<Books> books, Date issueDate, int quantity, Date dueDate) {
		super();
		this.issueId = issueId;
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

}
