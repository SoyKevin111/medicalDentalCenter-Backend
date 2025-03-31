package com.example.project.medicalconsultation.domain.port.out;

import com.example.project.medicalconsultation.domain.MedicalConsultation;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;

import java.util.List;
import java.util.Optional;

public interface IMedicalConsultationRepository {
  Optional< MedicalConsultation> findById(Long id);
   List<MedicalConsultation> findAll();
   MedicalConsultation save(MedicalConsultation medicalConsultation); //create, udpdate
   void deleteById(Long id);
}
