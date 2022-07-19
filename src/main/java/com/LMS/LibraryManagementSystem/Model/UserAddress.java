package com.LMS.LibraryManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_Address")
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int addressId;

	@Column
	private String address2;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private int pincode;

	@OneToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "userId", insertable = false, updatable = false)
	private Users users;

	public UserAddress() {
		super();
	}

	public UserAddress(int addressId, String address2, String city, String state, int pincode, Users users) {
		super();
		this.addressId = addressId;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.users = users;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
