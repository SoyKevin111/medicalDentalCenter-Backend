package com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.database;

import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalConsultationRepositorySql extends JpaRepository<MedicalConsultationEntity, Long> {

}
