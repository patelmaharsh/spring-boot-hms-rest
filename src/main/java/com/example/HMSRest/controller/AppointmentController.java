package com.example.HMSRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.HMSRest.StaticConfig;
import com.example.HMSRest.model.Appointment;
import com.example.HMSRest.repositories.AppointmentRepository;

@RestController
@CrossOrigin(origins = StaticConfig.crossOrigin)
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@GetMapping("/hms/{username}/appointments")
	public List<Appointment> getAllAppointments(@PathVariable String username){
		return appointmentRepo.findAll();
	}
	@GetMapping("/hms/{username}/allappointments")
	public long getAllAppointmentsCount(@PathVariable String username){
		return appointmentRepo.count();
	}
	@GetMapping("/hms/{username}/appointments/{id}")
	public Optional<Appointment> getAppointmentById(@PathVariable String username, @PathVariable long id) {
		return appointmentRepo.findById(id);
	} 
	@PutMapping("/hms/{username}/appointments")
	public void updateMedicine(@PathVariable String username, @RequestBody Appointment a){
		appointmentRepo.save(a);
	}
	@PostMapping("/hms/{username}/appointments")
	public int addAppointment(@PathVariable String username, @RequestBody Appointment a){
		Appointment createdAppointment = appointmentRepo.save(a);
		String uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdAppointment.getId()).toString();
		
		String[] sendInt = uri.split("/");
		int ans = Integer.parseInt(sendInt[sendInt.length -1]);
		return ans;
	}
	
}
