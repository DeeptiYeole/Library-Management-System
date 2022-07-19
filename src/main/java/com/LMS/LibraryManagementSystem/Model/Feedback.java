package com.LMS.LibraryManagementSystem.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {

	@Id
	@Column
	private int id;

	@OneToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "userId", insertable = false, updatable = false)
	private Users users;

	@Column
	private Date feedbackDate;

	@Column
	private String description;

	@Column
	private String rating;

	@Column
	private String comments;

	
	public Feedback() {
		super();
	}

	public Feedback(int id, Users users, Date feedbackDate, String description, String rating, String comments) {
		super();
		this.id = id;
		this.users = users;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
