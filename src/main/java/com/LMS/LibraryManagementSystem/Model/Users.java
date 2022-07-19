package com.LMS.LibraryManagementSystem.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Table")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int userId;

	@Column
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String mobileno;

	@Column
	private String email;

	@Column
	private Date date_of_birth;

	@Column
	private Date subscription_date;

	@Column
	private Date sub_expire_date;

	@Column
	private String subscription_status;
	
	public Users() {
		super();
	}

	public Users(int userId, String password, String firstName, String lastName, String mobileno, String email,
			Date date_of_birth, Date subscription_date, Date sub_expire_date, String subscription_status) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(Date subscription_date) {
		this.subscription_date = subscription_date;
	}

	public Date getSub_expire_date() {
		return sub_expire_date;
	}

	public void setSub_expire_date(Date sub_expire_date) {
		this.sub_expire_date = sub_expire_date;
	}

	public String getSubscription_status() {
		return subscription_status;
	}

	public void setSubscription_status(String subscription_status) {
		this.subscription_status = subscription_status;
	}

}
