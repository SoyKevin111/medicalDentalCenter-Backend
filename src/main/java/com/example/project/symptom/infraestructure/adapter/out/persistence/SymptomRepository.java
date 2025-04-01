package com.example.project.symptom.infraestructure.adapter.out.persistence;

import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.out.ISymptomRepository;
import com.example.project.symptom.infraestructure.adapter.out.persistence.mysql.SymptomRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository implements ISymptomRepository {

   @Autowired
   private SymptomRepositoryMysql symptomRepository;


   @Override
   public Symptom save(Symptom symptom) {
      return this.symptomRepository.save(symptom);
   }

   @Override
   public List<Symptom> findAll() {
      return (List<Symptom>) this.symptomRepository.findAll();
   }

   @Override
   public Optional<Symptom> findById(Long id) {
      return this.symptomRepository.findById(id);
   }
}
