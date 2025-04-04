package com.example.project.previousEvaluation.domain.validation;

import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PreviousEvaluationItemRequestValidator {
   public void createValidator(PreviousEvaluationItemRequest peir){
      List<String> errors = new ArrayList<>();

      if(peir.getSymptomId() == null || peir.getSymptomId().toString().isEmpty()){
         errors.add("Id del sintoma ingresado, indefinido o vacio.");
      }

      if(peir.getHasSymptom()== null){
         errors.add("Estado del sintoma indefinido (true/false)");
      }

      if(!errors.isEmpty()){
         throw new GeneralValidationException("[Error Domain, Property] PreviousEvaluationItem Request",errors);
      }
   }
}



