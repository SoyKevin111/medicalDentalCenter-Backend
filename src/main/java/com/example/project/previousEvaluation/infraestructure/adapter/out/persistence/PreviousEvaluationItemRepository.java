package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PreviousEvaluationItemRepository implements IPreviousEvaluationItemRepository {
   @Override
   public PreviousEvaluationItem save(PreviousEvaluationItem previousEvaluationItem) {
      return null;
   }

   @Override
   public Optional<PreviousEvaluationItem> findById(Long id) {
      return Optional.empty();
   }

   @Override
   public List<PreviousEvaluationItem> findAll() {
      return List.of();
   }
}
