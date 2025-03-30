package com.example.project.medicalconsultation.domain.port.in;

import com.example.project.medicalconsultation.domain.MedicalConsultation;
import com.example.project.medicalconsultation.domain.MedicalConsultationDto;
import com.example.project.medicalconsultation.domain.MedicalConsultationRequest;

import java.util.List;
import java.util.Optional;

public interface IMedicalConsultationUseCase {
   Optional<MedicalConsultation> findById(Long id);
   List<MedicalConsultation> findAll();
   Optional<MedicalConsultation> create(MedicalConsultationRequest medicalConsultationRequest);
   Optional<MedicalConsultation> update(MedicalConsultationRequest medicalConsultationRequest, Long id);
   void deleteById(Long id);
}
