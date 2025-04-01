package com.example.project.previousEvaluation.application.usecase;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationItemUseCase;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationItemRepository;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreviousEvaluationItemUseCase implements IPreviousEvaluationItemUseCase {

   @Autowired
   IPreviousEvaluationItemRepository previousEvaluationItemRepository;
   @Autowired
   ISymptomUseCase symptomUseCase;

   @Override
   public PreviousEvaluationItem create(PreviousEvaluationItemRequest previousEvaluationItemRequest) {//id symptom, value
      //validaciones...
      Optional<Symptom> optionalSymptom = this.symptomUseCase.findById(previousEvaluationItemRequest.getSymptomId());
      if(optionalSymptom.isPresent()){
         PreviousEvaluationItem p =  PreviousEvaluationItem.builder()
            .value(previousEvaluationItemRequest.isValue())
            .symptom(optionalSymptom.get())
            .build();
         return this.previousEvaluationItemRepository.save(p);
      }
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
