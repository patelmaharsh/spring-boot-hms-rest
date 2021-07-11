package com.example.HMSRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HMSRest.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
