package com.example.HMSRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HMSRest.model.DoctorLoginTable;

public interface DoctorLoginRepository extends JpaRepository<DoctorLoginTable, Long>{

	public DoctorLoginTable findByUsername(String username);

}
