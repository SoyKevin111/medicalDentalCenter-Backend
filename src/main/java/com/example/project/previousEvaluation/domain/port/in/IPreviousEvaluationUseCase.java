package com.example.project.previousEvaluation.domain.port.in;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;

import java.util.List;
import java.util.Optional;

public interface IPreviousEvaluationUseCase {
   PreviousEvaluation create(PreviousEvaluationRequest previousEvaluationRequest);
   List<PreviousEvaluation> findAll();
   Optional<PreviousEvaluation> findById(Long id);
   boolean existsById(Long id);
}
