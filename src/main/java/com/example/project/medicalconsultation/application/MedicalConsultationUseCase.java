package com.example.project.medicalconsultation.application;

import com.example.project.medicalconsultation.domain.MedicalConsultation;
import com.example.project.medicalconsultation.domain.MedicalConsultationRequest;
import com.example.project.medicalconsultation.domain.port.in.IMedicalConsultationUseCase;
import com.example.project.medicalconsultation.domain.port.out.IMedicalConsultationRepository;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorUseCase;
import com.example.project.utils.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalConsultationUseCase implements IMedicalConsultationUseCase {

   @Autowired
   IMedicalConsultationRepository medicalConsultationRepository;
   @Autowired
   ISpecialistDoctorUseCase specialistDoctorUseCase;

   @Transactional()
   @Override
   public Optional<MedicalConsultation> create(MedicalConsultationRequest medicalConsultationRequest) {
      Optional<SpecialistDoctor> specialistDoctorOptional = specialistDoctorUseCase.findById(medicalConsultationRequest.getSpecialistDoctorId());
      try {
         MedicalConsultation medicalConsultation = MedicalConsultation.builder()
            .specialistDoctor(specialistDoctorOptional.get())
            .diagnostic(medicalConsultationRequest.getDiagnostic())
            .build();
         return Optional.of(this.medicalConsultationRepository.save(medicalConsultation));
      }
      catch (Exception ex){
         throw new GeneralValidationException("[Error Database]MedicalConsultation", List.of("Error al guardar la consulta medica en la base de datos."));
      }
   }

   @Transactional(readOnly = true)
   @Override
   public Optional<MedicalConsultation> findById(Long id) {
      return Optional.empty();
   }

   @Transactional(readOnly = true)
   @Override
   public List<MedicalConsultation> findAll() {
      return this.medicalConsultationRepository.findAll();
   }


   @Transactional()
   @Override
   public Optional<MedicalConsultation> update(MedicalConsultationRequest medicalConsultationRequest, Long id) {
      return Optional.empty();
   }

   @Transactional()
   @Override
   public void deleteById(Long id) {

   }

}
