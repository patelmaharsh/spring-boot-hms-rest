package com.example.HMSRest.model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private long doctorId;
	@Column(nullable = false)
	private long patientId;
	
	private HashMap<String, Integer> medicines;
	private String prescription;
	private Date timestamp;
	@Column(nullable = false)
	private double totalBill;
	private double caseFees;
	
	
	public HashMap<String, Integer> getMedicines() {
		return medicines;
	}
	public void setMedicines(HashMap<String, Integer> medicines) {
		this.medicines = medicines;
	}
	public double getCaseFees() {
		return caseFees;
	}
	public void setCaseFees(double caseFees) {
		this.caseFees = caseFees;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", doctorId=" + doctorId + ", patientId=" + patientId + ", medicines="
				+ medicines + ", prescription=" + prescription + ", timestamp=" + timestamp + ", totalBill=" + totalBill
				+ ", caseFees=" + caseFees + "]";
	}
	
	
	
	
	
	
	
	
	
}
