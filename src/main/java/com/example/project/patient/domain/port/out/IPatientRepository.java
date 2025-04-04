package com.example.project.patient.domain.port.out;

import com.example.project.patient.domain.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientRepository {
   Patient save(Patient patient);
   Patient update(Patient patient);
   void delete(Long id);
   Optional<Patient> findById(Long id);
   List<Patient> findAll();
   boolean existsByIdentification(String identification);
}
