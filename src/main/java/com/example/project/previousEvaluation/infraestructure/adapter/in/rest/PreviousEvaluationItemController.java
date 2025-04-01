package com.example.project.previousEvaluation.infraestructure.adapter.in.rest;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationItemUseCase;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-center/service/previous-entity-item")
public class PreviousEvaluationItemController {

   @Autowired
   IPreviousEvaluationItemUseCase previousEvaluationItemUseCase;


   @PostMapping
   public ResponseEntity<?> create(@RequestBody PreviousEvaluationItemRequest previousEvaluationItemRequest){
      PreviousEvaluationItem p =  this.previousEvaluationItemUseCase.create(previousEvaluationItemRequest);
      return ResponseEntity.ok().body(p);
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<PreviousEvaluationItem> optionalPreviousEvaluationItem = this.previousEvaluationItemUseCase.findById(id);
      if (optionalPreviousEvaluationItem.isEmpty()){
         return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok().body(optionalPreviousEvaluationItem.get());
   }

   @GetMapping
   public List<PreviousEvaluationItem> findAll(){
      return this.previousEvaluationItemUseCase.findAll();
   }

}
