package com.example.project.symptom.infraestructure.adapter.out.persistence;

import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.out.ISymptomRepository;
import com.example.project.symptom.infraestructure.adapter.out.persistence.database.SymptomRepositoryMysql;
import com.example.project.symptom.infraestructure.adapter.out.persistence.entity.SymptomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository implements ISymptomRepository {

   @Autowired
   private SymptomRepositoryMysql symptomRepository;
   @Autowired
   private SymptomMapper mapper;

   @Override
   public Symptom save(Symptom symptom) {
      SymptomEntity symptomEntity = this.mapper.toEntity(symptom);
      return this.mapper.toDomain(this.symptomRepository.save(symptomEntity));
   }

   @Override
   public List<Symptom> findAll() {
      return ((List<SymptomEntity>) this.symptomRepository.findAll())
         .stream()
         .map(entity -> this.mapper.toDomain(entity))
         .toList();
   }

   @Override
   public Optional<Symptom> findById(Long id) {
      return this.symptomRepository.findById(id).map(
         entity -> this.mapper.toDomain(entity)
      );
   }
}
