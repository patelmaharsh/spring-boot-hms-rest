package com.example.HMSRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorLoginTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String hospitalName;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String phone;
	@Column(nullable=false)
	private int newCaseFees;
	@Column(nullable=false)
	private int oldCaseFees;
	
	public int getNewCaseFees() {
		return newCaseFees;
	}
	public void setNewCaseFees(int newCaseFees) {
		this.newCaseFees = newCaseFees;
	}
	public int getOldCaseFees() {
		return oldCaseFees;
	}
	public void setOldCaseFees(int oldCaseFees) {
		this.oldCaseFees = oldCaseFees;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DoctorLoginTable [id=" + id + ", username=" + username + ", hospitalName=" + hospitalName + ", name="
				+ name + ", password=" + password + ", address=" + address + ", phone=" + phone + ", newCaseFees="
				+ newCaseFees + ", oldCaseFees=" + oldCaseFees + "]";
	}
	
	
	
	
}
