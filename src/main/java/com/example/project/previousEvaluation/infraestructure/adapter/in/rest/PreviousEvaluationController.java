package com.example.project.previousEvaluation.infraestructure.adapter.in.rest;

import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationUseCase;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical-center/service/previous-evaluation")
public class PreviousEvaluationController {

   @Autowired
   private IPreviousEvaluationUseCase previousEvaluationUseCase;

   @PostMapping
   public ResponseEntity<?> create(@RequestBody PreviousEvaluationRequest previousEvaluationRequest){
      return ResponseEntity.ok().body(this.previousEvaluationUseCase.create(previousEvaluationRequest));
   }

}
