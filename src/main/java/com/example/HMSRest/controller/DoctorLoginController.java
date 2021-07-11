package com.example.HMSRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.HMSRest.StaticConfig;
import com.example.HMSRest.model.DoctorLoginTable;
import com.example.HMSRest.repositories.DoctorLoginRepository;

@RestController
@CrossOrigin(origins = StaticConfig.crossOrigin)
public class DoctorLoginController {
	@Autowired
	private DoctorLoginRepository doctorLoginRepo;
	
	@GetMapping("/hms/get/doctor/{username}")
	public DoctorLoginTable getDoctor(@PathVariable String username) {
		DoctorLoginTable d = doctorLoginRepo.findByUsername(username);
		return d;		
	}
}
