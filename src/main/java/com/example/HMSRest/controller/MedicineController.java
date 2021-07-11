package com.example.HMSRest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.HMSRest.StaticConfig;
import com.example.HMSRest.model.Medicine;
import com.example.HMSRest.repositories.MedicineRepository;

@RestController
@CrossOrigin(origins = StaticConfig.crossOrigin)
public class MedicineController {
	@Autowired
	private MedicineRepository medicineRepo;
	
	@GetMapping("/hms/{username}/medicines")
	public List<Medicine> getAllMedicines(@PathVariable String username){
		return medicineRepo.findAll();
	}
	@GetMapping("/hms/{username}/allmedicines")
	public long getAllMedicinesCount(@PathVariable String username){
		return medicineRepo.count();
	}
	@GetMapping("/hms/{username}/medicines/{id}")
	public Optional<Medicine> getMedicineById(@PathVariable String username, @PathVariable long id) {
		return medicineRepo.findById(id);
	}
	@PutMapping("/hms/{username}/medicines")
	public void updateMedicine(@PathVariable String username, @RequestBody Medicine m){
		medicineRepo.save(m);
	}
	@PostMapping("/hms/{username}/medicines")
	public ResponseEntity<Void> addMedicine(@PathVariable String username, @RequestBody Medicine m){
		Medicine createdMedicine = medicineRepo.save(m);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdMedicine.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PutMapping("/hms/{username}/medicines/{medicinename}/{quantitytoupdate}")
	public void updateMedicineStockByMedicineName(@PathVariable String username, @PathVariable String medicinename,@PathVariable int quantitytoupdate) {
		Medicine m = medicineRepo.findByName(medicinename);
		m.setAvailableStock(m.getAvailableStock()-quantitytoupdate);
		medicineRepo.save(m);
	}
	@DeleteMapping("/hms/{username}/medicines/{id}")
	public void deletePatient(@PathVariable String username, @PathVariable long id){
		medicineRepo.deleteById(id);
	}
}
