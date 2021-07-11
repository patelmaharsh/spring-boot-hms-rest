package com.example.HMSRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HMSRest.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

	Medicine findByName(String medicinename);
	
}
