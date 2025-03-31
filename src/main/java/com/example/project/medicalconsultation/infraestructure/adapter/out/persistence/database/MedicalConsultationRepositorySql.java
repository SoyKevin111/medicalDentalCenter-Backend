package com.example.project.medicalconsultation.infraestructure.adapter.out.persistence.database;

import com.example.project.medicalconsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalConsultationRepositorySql extends JpaRepository<MedicalConsultationEntity, Long> {

}
