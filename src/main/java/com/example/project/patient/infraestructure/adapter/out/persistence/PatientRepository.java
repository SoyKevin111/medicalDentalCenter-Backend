package com.example.project.patient.infraestructure.adapter.out.persistence;

import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.out.IPatientRepository;
import com.example.project.patient.infraestructure.adapter.out.persistence.database.PatientRepositorySql;
import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import com.example.project.shared.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository implements IPatientRepository {

   @Autowired
   PatientRepositorySql patientRepository;

   @Autowired
   GeneralMapper generalMapper;

   @Override
   public Patient save(Patient patient) {
      PatientEntity patientEntity = this.patientRepository.save(this.generalMapper.toEntity(patient, PatientEntity.class));
      return this.generalMapper.toDomain(patientEntity, Patient.class);
   }

   @Override
   public Patient update(Patient patient) {
      PatientEntity patientEntity = this.patientRepository.save(this.generalMapper.toEntity(patient, PatientEntity.class));
      return this.generalMapper.toDomain(patientEntity, Patient.class);
   }

   @Override
   public void delete(Long id) {
      this.patientRepository.deleteById(id);
   }

   @Override
   public Optional<Patient> findById(Long id) {
      return this.patientRepository.findById(id).map(e -> generalMapper.toEntity(e, Patient.class));
   }

   @Override
   public List<Patient> findAll() {
      return ((List<PatientEntity>) this.patientRepository.findAll())
         .stream()
         .map(e -> this.generalMapper.toDomain(e, Patient.class)).toList();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return this.patientRepository.existsByIdentification(identification);
   }
}
