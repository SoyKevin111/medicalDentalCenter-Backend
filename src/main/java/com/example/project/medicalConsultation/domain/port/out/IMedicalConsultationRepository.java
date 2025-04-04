package com.example.project.medicalConsultation.domain.port.out;

import com.example.project.medicalConsultation.domain.MedicalConsultation;

import java.util.List;
import java.util.Optional;

public interface IMedicalConsultationRepository {
  Optional< MedicalConsultation> findById(Long id);
   List<MedicalConsultation> findAll();
   MedicalConsultation save(MedicalConsultation medicalConsultation); //create, udpdate
   void deleteById(Long id);
}
