//package com.example.HMSRest.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.HMSRest.repositories.AppointmentRepository;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class StatsController {
//	@Autowired
//	AppointmentRepository appointmentRepo;
//	
//	@GetMapping("/hms/{username}/getsumcasefees")
//	public double getSumCaseFees(@PathVariable String username) {
//		return appointmentRepo.sumCaseFees();
//	}
//	@GetMapping("/hms/{username}/getsumallfees")
//	public double getSumAllFees(@PathVariable String username) {
//		return appointmentRepo.sumTotalBill();
//	}
//	@GetMapping("/hms/{username}/getsummedicine")
//	public double getSumAllMedicines(@PathVariable String username) {
//		return appointmentRepo.sumTotalBill()-appointmentRepo.sumCaseFees();
//	}
//}
