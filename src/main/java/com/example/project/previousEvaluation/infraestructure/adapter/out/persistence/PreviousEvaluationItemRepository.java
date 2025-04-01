package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationItemRepository;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.database.PreviousEvaluationItemRepositorySql;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationItemEntity;
import com.example.project.symptom.domain.Symptom;
import com.example.project.utils.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PreviousEvaluationItemRepository implements IPreviousEvaluationItemRepository {

   @Autowired
   PreviousEvaluationItemRepositorySql previousEvaluationItemRepository;
   @Autowired
   GeneralMapper mapper;

   @Override
   public PreviousEvaluationItem save(PreviousEvaluationItem previousEvaluationItem) {
      PreviousEvaluationItemEntity peie = this.mapper.toEntity(previousEvaluationItem, PreviousEvaluationItemEntity.class);
      if(previousEvaluationItem.getSymptom() != null){
         peie.setSymptom(
            this.mapper.toEntity(previousEvaluationItem.getSymptom(), Symptom.class)//ojooo xd, es de dominio pero esta mapeado a sql, seria como un Entity
         );
         return this.mapper.toDomain(this.previousEvaluationItemRepository.save(peie), PreviousEvaluationItem.class);
      }
      return null;
   }

   @Override
   public Optional<PreviousEvaluationItem> findById(Long id) {

      return this.previousEvaluationItemRepository.findById(id).map(
         e -> this.mapper.toDomain(e, PreviousEvaluationItem.class)
      );
   }

   @Override
   public List<PreviousEvaluationItem> findAll() {
      return ((List<PreviousEvaluationItemEntity>) this.previousEvaluationItemRepository.findAll())
         .stream()
         .map(e ->
            this.mapper.toDomain(e, PreviousEvaluationItem.class)
         ).toList();
   }
}
