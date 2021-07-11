package com.example.HMSRest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true,nullable = false)
	private String name;
	private String companyName;
	@Column(nullable = false)
	private double sellPrice;
	@Column(nullable = false)
	private double costPrice;
	private String medicineType;
	private Date mfg;
	private double bestBefore; // in months
	private int availableStock;
	public int getAvailableStock() {
		return availableStock;
	}
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Date getMfg() {
		return mfg;
	}
	public void setMfg(Date mfg) {
		this.mfg = mfg;
	}
	public double getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(double bestBefore) {
		this.bestBefore = bestBefore;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", companyName=" + companyName + ", sellPrice=" + sellPrice
				+ ", costPrice=" + costPrice + ", medicineType=" + medicineType + ", mfg=" + mfg + ", bestBefore="
				+ bestBefore + ", availableStock=" + availableStock + "]";
	}
	
	
	
}
