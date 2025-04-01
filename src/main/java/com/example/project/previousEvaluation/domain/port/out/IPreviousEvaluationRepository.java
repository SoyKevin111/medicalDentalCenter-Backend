package com.example.project.previousEvaluation.domain.port.out;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;

import java.util.List;
import java.util.Optional;

public interface IPreviousEvaluationRepository {
   PreviousEvaluation save(PreviousEvaluation previousEvaluation);
   Optional<PreviousEvaluation> findById(Long id);
   List<PreviousEvaluation> findAll();
}
