package com.example.project.patient.domain.port.in;

import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.PatientRequest;

import java.util.List;
import java.util.Optional;

public interface IPatientUseCase {
   //get, add, delete, update
   Patient save(PatientRequest patientRequest);
   Optional<Patient> update(PatientRequest patientRequest, Long id);
   void delete(Long id);
   Optional<Patient> findById(Long id);
   List<Patient> findAll();
   boolean existsByIdentification(String identification);

}
