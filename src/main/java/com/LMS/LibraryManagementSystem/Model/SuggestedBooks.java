package com.LMS.LibraryManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SuggestedBooks")
public class SuggestedBooks {

	@Id
	@Column
	private int id;

	@OneToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "userId", insertable = false, updatable = false)
	private Users users;

	@Column
	private String title;

	@Column
	private String subject;

	@Column
	private String author;

	@Column
	private String publications;

	@Column
	private String description;

	@Column
	private String suggested_date;

	@Column
	private String status;

	public SuggestedBooks() {
		super();
	}

	public SuggestedBooks(int id, Users users, String title, String subject, String author, String publications,
			String description, String suggested_date, String status) {
		super();
		this.id = id;
		this.users = users;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuggested_date() {
		return suggested_date;
	}

	public void setSuggested_date(String suggested_date) {
		this.suggested_date = suggested_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
