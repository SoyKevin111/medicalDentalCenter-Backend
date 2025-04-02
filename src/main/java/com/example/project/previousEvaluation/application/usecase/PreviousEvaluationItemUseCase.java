package com.example.project.previousEvaluation.application.usecase;

import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationItemUseCase;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationItemRepository;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.previousEvaluation.domain.validation.PreviousEvaluationItemRequestValidator;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import com.example.project.utils.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreviousEvaluationItemUseCase implements IPreviousEvaluationItemUseCase {

   @Autowired
   IPreviousEvaluationItemRepository previousEvaluationItemRepository;
   @Autowired
   ISymptomUseCase symptomUseCase;
   @Autowired
   PreviousEvaluationItemRequestValidator validator;


   @Transactional
   @Override
   public PreviousEvaluationItem create(PreviousEvaluationItemRequest previousEvaluationItemRequest) {//id symptom, value
      this.validator.createValidator(previousEvaluationItemRequest);
      Optional<Symptom> optionalSymptom = this.symptomUseCase.findById(previousEvaluationItemRequest.getSymptomId());
      if(optionalSymptom.isPresent()){
         PreviousEvaluationItem p =  PreviousEvaluationItem.builder()
            .hasSymptom(previousEvaluationItemRequest.getHasSymptom())
            .symptom(optionalSymptom.get())
            .build();
         return this.previousEvaluationItemRepository.save(p);
      }
      return null;
   }

   @Override
   public Optional<PreviousEvaluationItem> findById(Long id) {
      Optional<PreviousEvaluationItem> optionalPreviousEvaluationItem = this.previousEvaluationItemRepository.findById(id);
      if(optionalPreviousEvaluationItem.isEmpty()){
         throw new GeneralValidationException("[Error Database, findById()] PreviousEvaluationItem",List.of("Error al obtener al item por ID."));
      }
      return optionalPreviousEvaluationItem;
   }

   @Override
   public List<PreviousEvaluationItem> findAll() {
      return (List<PreviousEvaluationItem>) this.previousEvaluationItemRepository.findAll();
   }
}
