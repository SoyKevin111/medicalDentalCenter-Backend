package com.example.project.symptom.application;

import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.out.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomUseCase implements ISymptomUseCase {

   @Autowired
   private ISymptomRepository symptomRepository;

   @Override
   public Symptom create(Symptom symptom) {
      try {
         return this.symptomRepository.save(symptom);
      }
      catch (Exception e){
         throw  new RuntimeException("Error al guardar el sintoma: "+e);
      }
   }

   @Override
   public List<Symptom> findAll() {
      return (List<Symptom>) this.symptomRepository.findAll();
   }
}
