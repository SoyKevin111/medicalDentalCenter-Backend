package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationRepository;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.database.PreviousEvaluationRepositorySql;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import com.example.project.utils.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PreviousEvaluationRepository implements IPreviousEvaluationRepository {

   @Autowired
   private PreviousEvaluationRepositorySql previousEvaluationRepository;
   @Autowired
   private GeneralMapper generalMapper;

   public PreviousEvaluation save(PreviousEvaluation previousEvaluation) {
      PreviousEvaluationEntity previousEvaluationEntity = this.generalMapper.toEntity(previousEvaluation, PreviousEvaluationEntity.class);
      return this.generalMapper.toDomain(this.previousEvaluationRepository.save(previousEvaluationEntity), PreviousEvaluation.class);
   }

   @Override
   public Optional<PreviousEvaluation> findById(Long id) {
      return Optional.empty();
   }

   @Override
   public List<PreviousEvaluation> findAll() {
      return List.of();
   }
}
