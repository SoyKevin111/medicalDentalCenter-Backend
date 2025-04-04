package com.example.project.patient.application.usecase;

import com.example.project.patient.domain.PatientRequest;
import com.example.project.patient.domain.port.in.IPatientUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.out.IPatientRepository;
import com.example.project.patient.domain.validation.PatientValidator;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientUseCase implements IPatientUseCase {

   @Autowired
   IPatientRepository patientRepository;

   @Autowired
   PatientValidator patientValidator;

   @Override
   public Patient save(PatientRequest patientRequest) {
      List<String> errors = this.patientValidator.validatePatientData(patientRequest);
      if(!errors.isEmpty()){
         throw new GeneralValidationException("[Error Domain]Patient entered fields.",errors);
      } //validaciones de dominio

      if(patientRepository.existsByIdentification(patientRequest.getIdentification())){ //validaciones en la base de datos.
         throw new GeneralValidationException("[Error Database]Patient",List.of("Error de creacion, paciente existente."));
      }

      Patient patient = Patient.builder()
         .surname(patientRequest.getSurname())
         .name(patientRequest.getName())
         .gender(patientRequest.getGender())
         .identification(patientRequest.getIdentification())
         .age(patientRequest.getAge())
         .build();

      return this.patientRepository.save(patient);
   }

   @Override
   public Optional<Patient> update(PatientRequest patientRequest, Long id) {
      List<String> errors = this.patientValidator.validateRequestPatientData(patientRequest);
      if(!errors.isEmpty()){
         throw new GeneralValidationException("[Error Domain]RequestPatient",errors);
      } //validaciones de dominio

      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isPresent()){
         Patient patientDB = optionalPatient.get();
         patientDB.setName(patientRequest.getName());
         patientDB.setSurname(patientRequest.getSurname());
         patientDB.setAge(patientRequest.getAge());

         return Optional.of(this.patientRepository.update(patientDB));
      }//validaciones de base datos
      return Optional.empty();
   }

   @Override
   public void delete(Long id) {
      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isEmpty()){
         throw new GeneralValidationException("[Error Database]Patient",List.of("Error de busqueda, no se encontro el paciente para eliminar."));
      }
      this.patientRepository.delete(id); //yes
   }

   @Override
   public Optional<Patient> findById(Long id) {
      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isEmpty()){
         throw new GeneralValidationException("[Error Database]Patient",List.of("Error de busqueda, no se encontro el paciente."));
      }
      return  optionalPatient;
   }

   @SuppressWarnings({"rawtypes","unchecked"})
   @Override
   public List<Patient> findAll() {
      return (List) this.patientRepository.findAll();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return this.patientRepository.existsByIdentification(identification);
   }
}
