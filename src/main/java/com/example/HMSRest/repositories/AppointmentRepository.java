package com.example.HMSRest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.HMSRest.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findAllByPatientId(Long id);
	
	@Query("SELECT a FROM Appointment a where a.patientId = ?2 and a.caseFees = ?1 order by timestamp desc")
 	Optional<Appointment> findPatientFirstAppointment(double newCaseFees, long patientId);

  	Optional<Appointment> findTop1ByPatientIdAndCaseFeesOrderByTimestampDesc(long id,double patientId);
	
	@Query(value = "SELECT sum(case_fees) FROM Appointment",nativeQuery=true)
	double sumCaseFees();
	
	@Query(value = "SELECT sum(total_bill) FROM Appointment",nativeQuery=true)
	double sumTotalBill();
}
 