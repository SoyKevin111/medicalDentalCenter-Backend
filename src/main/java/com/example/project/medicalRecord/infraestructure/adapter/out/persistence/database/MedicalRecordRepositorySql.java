package com.example.project.medicalRecord.infraestructure.adapter.out.persistence.database;

import com.example.project.medicalRecord.infraestructure.adapter.out.persistence.entity.MedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepositorySql extends JpaRepository<MedicalRecordEntity, Long> {

}
