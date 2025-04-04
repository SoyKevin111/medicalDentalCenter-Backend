package com.example.project.medicalConsultation.application;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.medicalConsultation.domain.MedicalConsultationRequest;
import com.example.project.medicalConsultation.domain.port.in.IMedicalConsultationUseCase;
import com.example.project.medicalConsultation.domain.port.out.IMedicalConsultationRepository;
import com.example.project.medicalConsultation.domain.validation.MedicalConsultationRequestValidator;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorUseCase;
import com.example.project.shared.exception.GeneralValidationException;
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
   @Autowired
   MedicalConsultationRequestValidator validator;

   @Transactional()
   @Override
   public Optional<MedicalConsultation> create(MedicalConsultationRequest medicalConsultationRequest) {
      this.validator.requestValidator(medicalConsultationRequest);
      List<String> errors = validator.createValidator(medicalConsultationRequest);
      if (!errors.isEmpty()) {
         throw new GeneralValidationException("[Error Domain, create()] MedicalConsultation", errors);
      }
      Optional<SpecialistDoctor> specialistDoctorOptional = specialistDoctorUseCase.findById(medicalConsultationRequest.getSpecialistDoctorId());
      try {
         MedicalConsultation medicalConsultation = MedicalConsultation.builder()
            .specialistDoctor(specialistDoctorOptional.get())
            .diagnostic(medicalConsultationRequest.getDiagnostic())
            .build();
         return Optional.of(this.medicalConsultationRepository.save(medicalConsultation));
      } catch (Exception ex) {
         throw new GeneralValidationException("[Error Database]MedicalConsultation", List.of("Error al guardar la consulta medica en la base de datos."));
      }
   }

   @Transactional(readOnly = true)
   @Override
   public List<MedicalConsultation> findAll() {
      return this.medicalConsultationRepository.findAll();
   }


   @Transactional()
   @Override
   public Optional<MedicalConsultation> update(MedicalConsultationRequest medicalConsultationRequest, Long id) {
      this.validator.requestValidator(medicalConsultationRequest);
      MedicalConsultation medicalConsultation = medicalConsultationRepository.findById(id)
         .orElseThrow(()-> new GeneralValidationException("[Error Database, getById()]Medical Consultation",List.of("Consulta médica no encontrada.")));

      medicalConsultationRequest.setId(id);
      if(medicalConsultationRequest.getSpecialistDoctorId() != null){
         this.validator.validatorSpecialistDoctorId(id);
         Optional<SpecialistDoctor> specialistDoctor = specialistDoctorUseCase.findById(medicalConsultationRequest.getSpecialistDoctorId());
         specialistDoctor.ifPresent(medicalConsultation::setSpecialistDoctor); //specialistDoctor.ifPresent(s -> medicalConsultation.setSpecialistDoctor(s));
      }
      if (medicalConsultationRequest.getDiagnostic() != null) {
         this.validator.validatorDiagnostic(medicalConsultationRequest.getDiagnostic());
         medicalConsultation.setDiagnostic(medicalConsultationRequest.getDiagnostic());
      }
      return Optional.of(medicalConsultationRepository.save(medicalConsultation));

   }

   @Transactional()
   @Override
   public void deleteById(Long id) {
      Optional<MedicalConsultation> mc = this.medicalConsultationRepository.findById(id);
      if (mc.isPresent()) {
         this.medicalConsultationRepository.deleteById(id);
      }
   }

}
