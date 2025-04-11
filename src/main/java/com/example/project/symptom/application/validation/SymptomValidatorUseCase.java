package com.example.project.symptom.application.validation;

import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.out.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SymptomValidatorUseCase {

   @Autowired
   ISymptomRepository symptomRepository;

   public Symptom validateSymptomByIdExistence(Long id) {
      Optional<Symptom> symptomOptional = this.symptomRepository.findById(id);
      if (symptomOptional.isPresent()) {
         return symptomOptional.get();
      }

      throw new RuntimeException(""); //error de request
   }
}
