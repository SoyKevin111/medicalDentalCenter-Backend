package com.example.project.symptom.infraestructure.adapter.out.persistence;

import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.infraestructure.adapter.out.persistence.entity.SymptomEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SymptomMapper {

   private final ModelMapper mapper = new ModelMapper();

   public SymptomEntity toEntity(Symptom symptom) {
      return this.mapper.map(symptom, SymptomEntity.class);
   }

   public Symptom toDomain(SymptomEntity symptomEntity) {
      return this.mapper.map(symptomEntity, Symptom.class);
   }
}
