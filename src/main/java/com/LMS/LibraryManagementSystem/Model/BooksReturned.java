package com.LMS.LibraryManagementSystem.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books_Returned")
public class BooksReturned {

	@Id
	@Column
	private int Id;

	@OneToOne
//	@JoinColumn(name = "userid",referencedColumnName = "userId", insertable = false, updatable = false)
	private Users users;

	@OneToMany(mappedBy = "booksReturned")
	private List<Books> books;

	@Column
	private Date returnedDate;

	@Column
	private int delayed_Days;

	@Column
	private double penalty;

	@Column
	private String penalty_status;

	
	public BooksReturned() {
		super();
	}

	public BooksReturned(int id, Users users, List<Books> books, Date returnedDate, int delayed_Days, double penalty,
			String penalty_status) {
		super();
		Id = id;
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayed_Days = delayed_Days;
		this.penalty = penalty;
		this.penalty_status = penalty_status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public int getDelayed_Days() {
		return delayed_Days;
	}

	public void setDelayed_Days(int delayed_Days) {
		this.delayed_Days = delayed_Days;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public String getPenalty_status() {
		return penalty_status;
	}

	public void setPenalty_status(String penalty_status) {
		this.penalty_status = penalty_status;
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

}
