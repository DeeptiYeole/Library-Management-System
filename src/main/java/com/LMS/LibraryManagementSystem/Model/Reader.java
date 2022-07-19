package com.LMS.LibraryManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reader")
public class Reader {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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

	
	public Reader(int id, String password, String firstName, String lastName, String mobileno, String email) {
		super();
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
