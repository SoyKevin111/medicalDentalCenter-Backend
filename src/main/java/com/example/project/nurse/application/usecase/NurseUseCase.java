package com.example.project.nurse.application.usecase;

import com.example.project.nurse.domain.port.in.INurseUseCase;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import com.example.project.nurse.domain.validation.NurseValidator;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseUseCase implements INurseUseCase {

   @Autowired
   private INurseRepository nurseRepository;
   private final NurseValidator nurseValidator;

   public NurseUseCase(NurseValidator nurseValidator){
      this.nurseValidator = nurseValidator;
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<Nurse> getNurseById(Long id) {
      return Optional.ofNullable(this.nurseRepository.findById(id)
         .orElseThrow(() -> new GeneralValidationException("[Error Database]Nurse",List.of("Enfermera no encontrada."))));
   }

   @Override
   @Transactional
   public Nurse save(Nurse nurse) {
       List<String> errors = nurseValidator.validateNurseData(nurse.getName()); //validacion de dominio
       if(!errors.isEmpty()){
          throw new GeneralValidationException("[Error Domain]Nurse",errors);
       }
      if(this.nurseRepository.existsByName(nurse.getName())){ //eror de database
         throw new GeneralValidationException("[Error Database]Nurse",List.of("El Nombre ya se encuentra en uso."));
      }
      return this.nurseRepository.save(nurse);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Nurse> findAll() {
      return (List<Nurse>) this.nurseRepository.findAll();
   }

   @Override
   public Nurse findRandomNurse() {
      return this.nurseRepository.findRandomNurse();
   }

   @Override
   public boolean existsById(Long id) {
      return this.nurseRepository.existsById(id);
   }
}
