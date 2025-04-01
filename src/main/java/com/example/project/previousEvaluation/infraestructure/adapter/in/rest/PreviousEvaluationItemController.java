package com.example.project.previousEvaluation.infraestructure.adapter.in.rest;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationItemUseCase;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peva")
public class PreviousEvaluationItemController {

   @Autowired
   IPreviousEvaluationItemUseCase previousEvaluationItemUseCase;


   @PostMapping
   public ResponseEntity<?> create(@RequestBody PreviousEvaluationItemRequest previousEvaluationItemRequest){
      PreviousEvaluationItem p =  this.previousEvaluationItemUseCase.create(previousEvaluationItemRequest);
      return ResponseEntity.ok().body(p);
   }
}
