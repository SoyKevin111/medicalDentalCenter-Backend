package com.example.project.previousEvaluation.domain.port.in;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;

import java.util.List;

public interface IPreviousEvaluationUseCase {
   PreviousEvaluation create(PreviousEvaluationRequest previousEvaluationRequest);
   List<PreviousEvaluation> findAll();
}
