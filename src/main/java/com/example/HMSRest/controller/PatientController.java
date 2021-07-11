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

import com.example.HMSRest.model.Appointment;
import com.example.HMSRest.model.DoctorLoginTable;
import com.example.HMSRest.model.Patient;
import com.example.HMSRest.repositories.AppointmentRepository;
import com.example.HMSRest.repositories.DoctorLoginRepository;
import com.example.HMSRest.repositories.PatientRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private AppointmentRepository appointmentRepo;
	@Autowired
	private DoctorLoginRepository doctorLoginRepo;
	
	@GetMapping("/hms/{username}/patients")
	public List<Patient> getAllPatients(@PathVariable String username){
		return patientRepo.findAll();
	}
	@GetMapping("/hms/{username}/allpatients")
	public long getAllPatientsCount(@PathVariable String username){
		return patientRepo.count();
	}
	
	@GetMapping("/hms/{username}/patients/{id}")
	public Optional<Patient> getPatientById(@PathVariable String username, @PathVariable long id) {
		return patientRepo.findById(id);
	}
	@GetMapping("/hms/{username}/patients/{id}/appointment")
	public List<Appointment> getAppointmentByPatientId(@PathVariable String username, @PathVariable long id) {
		return appointmentRepo.findAllByPatientId(id);
	}
	@GetMapping("/hms/{username}/patients/{id}/getfirstappointment")
	public Optional<Appointment> getFirstAppointment(@PathVariable String username, @PathVariable long id) {
		DoctorLoginTable d = doctorLoginRepo.findByUsername(username);
//		Optional<Appointment> a = appointmentRepo.findPatientFirstAppointment((double)d.getNewCaseFees(),id);
		Optional<Appointment> a = appointmentRepo.findTop1ByPatientIdAndCaseFeesOrderByTimestampDesc(id,(double)d.getNewCaseFees());
		return a;
	}
	@PostMapping("/hms/{username}/patients/{id}/appointment")
	public void postAppointmentByPatientId(@PathVariable String username, @PathVariable long id, @RequestBody Appointment a) {
		appointmentRepo.save(a);
	}
	@PutMapping("/hms/{username}/patients")
	public void updatePatient(@PathVariable String username, @RequestBody Patient p){
		patientRepo.save(p);
	}
	@PostMapping("/hms/{username}/patients")
	public ResponseEntity<Void> addPatient(@PathVariable String username, @RequestBody Patient p){
		Patient createdPatient = patientRepo.save(p);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdPatient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/hms/{username}/patients/{id}")
	public void deletePatient(@PathVariable String username, @PathVariable long id){
		patientRepo.deleteById(id);
	}
}
