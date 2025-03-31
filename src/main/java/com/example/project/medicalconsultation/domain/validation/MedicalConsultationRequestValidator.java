package com.example.project.medicalconsultation.domain.validation;

import com.example.project.medicalconsultation.domain.MedicalConsultationRequest;
import com.example.project.utils.exception.GeneralValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicalConsultationRequestValidator {

   public List<String> createValidator(MedicalConsultationRequest mcr){
      List<String> errors = new ArrayList<>();

      if(mcr.getSpecialistDoctorId() == null || mcr.getSpecialistDoctorId().toString().isEmpty()){
         errors.add("Id, Medico especialista esta vacio o indefinido.");
      }
      if(mcr.getDiagnostic() == null || mcr.getDiagnostic().isEmpty()){
         errors.add("Diagnostico vacio o indefinido. ");
      }
      return errors;
   }

   public void requestValidator(MedicalConsultationRequest mcr){
      if(mcr.getDiagnostic() == null & mcr.getSpecialistDoctorId() ==null){
         throw new GeneralValidationException("[Error Domain, create()/update()] MedicalConsultationRequest",List.of("Consulta medica indefinida."));
      }
   }

   public void validatorDiagnostic(String diagnostic){
      if(diagnostic.isEmpty()){
         throw new GeneralValidationException("[Error Domain, update()] MedicalConsultationRequest",List.of("Diagnostico ingresado, vacio."));
      }
   }
   public void validatorSpecialistDoctorId(Long id){
      if(id.toString().isEmpty()){
         throw new GeneralValidationException("[Error Domain, update()] MedicalConsultationRequest",List.of("Id Medico Especialista ingresado, vacio."));
      }
   }

}
