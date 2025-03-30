package com.example.project.patient.infraestructure.adapter.out.persistence.database;

import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepositorySql extends JpaRepository<PatientEntity, Long> {
   //save
   //delete
   //update(save)
   //Optional<Patient> findById();
   //findAll()
   boolean existsByIdentification(String identification);
}
