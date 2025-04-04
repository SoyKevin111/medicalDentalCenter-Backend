package com.example.project.medicalConsultation.domain.port.in;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.medicalConsultation.domain.MedicalConsultationRequest;

import java.util.List;
import java.util.Optional;

public interface IMedicalConsultationUseCase {
   List<MedicalConsultation> findAll();
   Optional<MedicalConsultation> create(MedicalConsultationRequest medicalConsultationRequest);
   Optional<MedicalConsultation> update(MedicalConsultationRequest medicalConsultationRequest, Long id);
   void deleteById(Long id);
}
