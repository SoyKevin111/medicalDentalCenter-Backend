package com.example.project.patient.domain.validation;

import com.example.project.patient.domain.Gender;
import com.example.project.patient.domain.PatientRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PatientValidator {

   public List<String> validatePatientData(PatientRequest patientRequest) {
      List<String> errors = new ArrayList<>();

      if (patientRequest.getAge() < 3 || patientRequest.getAge() > 100) {
         errors.add("Edad menor a 3 o mayor a 100 no esta definido.");
      }

      if ( patientRequest.getIdentification() == null ||patientRequest.getIdentification().length() != 10) {
         errors.add("Longitud de Identificación debe ser 10.");
      }


      if (patientRequest.getGender() == null || patientRequest.getGender().toString().isEmpty()) {
         errors.add("Error propiedad Género no definida o vacia.");
      } else {
         String genderError = validateGender(patientRequest.getGender()); //no funciona la validacion por tipo
         if (genderError != null) {
            errors.add(genderError);
         }
      }

      if (patientRequest.getName() == null || patientRequest.getName().isEmpty()) {
         errors.add("Nombre ingresado esta vacio.");
      }

      if (patientRequest.getSurname() == null || patientRequest.getSurname().isEmpty()) {
         errors.add("Apellido ingresado esta vacio.");
      }

      return errors;
   }

   public List<String> validateRequestPatientData(PatientRequest patientRequest) {
      List<String> errors = new ArrayList<>();

      if (patientRequest.getAge() < 3 || patientRequest.getAge() > 100) {
         errors.add("Edad menor a 3 o mayor a 100 no esta permitido.");
      }

      if (patientRequest.getName() ==null || patientRequest.getName().isEmpty()) {
         errors.add("Nombre ingresado esta vacio.");
      }

      if (patientRequest.getSurname() ==null ||patientRequest.getSurname().isEmpty()) {
         errors.add("Apellido ingresado esta vacio.");
      }

      if(patientRequest.getGender() != null ){
         errors.add("Genero update, acceso denegado");
      }

      if(patientRequest.getIdentification() != null){
         errors.add("Identificacion update, acceso denegado");
      }

      return errors;
   }


   public String validateGender(Gender gender) {
      boolean isValid = Arrays.stream(Gender.values())
         .anyMatch(g -> g.equals(gender));

      if (isValid) {
         return null;
      } else {
         return "Tipo de género ingresado incorrecto.";
      }
   }


}
