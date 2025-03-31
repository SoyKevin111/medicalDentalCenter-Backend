package com.example.project.previousEvaluation.domain.port.out;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;

import java.util.List;
import java.util.Optional;

public interface IPreviousEvaluationItemRepository {
   PreviousEvaluationItem save(PreviousEvaluationItem previousEvaluationItem);
   Optional<PreviousEvaluationItem> findById(Long id);
   List<PreviousEvaluationItem> findAll();
}
