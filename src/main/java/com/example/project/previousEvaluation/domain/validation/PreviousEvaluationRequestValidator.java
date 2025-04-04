package com.example.project.previousEvaluation.domain.validation;

import com.example.project.previousEvaluation.domain.model.CaseSelected;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PreviousEvaluationRequestValidator {

   public void createValidator(PreviousEvaluationRequest per){
      List<String> errors = new ArrayList<>();
      String errorItems = this.itemsValidator(per.getPreviousEvaluationItemRequests());

      if(errorItems!= null){
         errors.add(errorItems);
      }

      if(per.getNurseId()  == null || per.getNurseId().toString().isEmpty()){
         errors.add("Id enfermera, vacio o indefinido");
      }

      if( per.getCaseSelected() == null){
         errors.add("Propiedad caso seleccionado vacio o indefinido");
      }

      if(!caseSelectedValidator(per.getCaseSelected())){
         errors.add("Caso seleccionado incorrecto (Solo: CARIES, BRACKETS, ENCIAS, OTROS)");
      }

      //valiacion final
      if(!errors.isEmpty()){
         throw new GeneralValidationException("Error Domain, create()] PreviousEvaluationRequest", errors);
      }

   }

   public boolean caseSelectedValidator(CaseSelected caseSelected){
      return Arrays.stream(CaseSelected.values())
         .anyMatch(c -> c.equals(caseSelected));

   }

   public String itemsValidator(List<PreviousEvaluationItemRequest> peir){
      if(peir.isEmpty()){
         return "Items vacios o < 1.";
      }
      if(peir.size() != 3){
         return "Error, items requeridos: 3, items enviados: "+peir.size();
      }
      Set<Long> symptomIds = new HashSet<>();
      for (PreviousEvaluationItemRequest item : peir){
         if(!symptomIds.add(item.getSymptomId())){
            return "Hay elementos repetidos con symptomId: "+item.getSymptomId();
         }
      }
      return null;
   }


}

