package com.example.project.symptom.application;

import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.out.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomUseCase implements ISymptomUseCase {

   @Autowired
   private ISymptomRepository symptomRepository;

   @Transactional
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

   @Transactional(readOnly = true)
   @Override
   public Optional<Symptom> findById(Long id) {
      Optional<Symptom> symptom = this.symptomRepository.findById(id);

      if(symptom.isPresent()){
         return symptom;
      }
      return Optional.empty();
   }
}
