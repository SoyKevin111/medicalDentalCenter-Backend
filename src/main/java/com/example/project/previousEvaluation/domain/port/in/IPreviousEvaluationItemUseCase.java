package com.example.project.previousEvaluation.domain.port.in;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;

import java.util.List;
import java.util.Optional;

public interface IPreviousEvaluationItemUseCase {
   PreviousEvaluationItem create(PreviousEvaluationItemRequest previousEvaluationItemRequest);
   Optional<PreviousEvaluationItem> findById(Long id);
   List<PreviousEvaluationItem> findAll();
}
