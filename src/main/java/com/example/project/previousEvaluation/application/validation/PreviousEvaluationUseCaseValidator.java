package com.example.project.previousEvaluation.application.validation;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.in.INurseUseCase;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import com.example.project.utils.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PreviousEvaluationUseCaseValidator {

   @Autowired
   private INurseUseCase nurseUseCase;
   @Autowired
   private ISymptomUseCase symptomUseCase;

   public Optional<Nurse> validadorNurse(Long id) {
      Optional<Nurse> optionalNurse = this.nurseUseCase.getNurseById(id);
      if (optionalNurse.isEmpty()) {
         throw new GeneralValidationException("[Error Database, ValidationNurse] PreviousEvaluationRequest", List.of("No se pudo encontrar la enfermera asignada a la evaluacion previa."));
      }
      return optionalNurse;
   }

   public void validationSymptomItems(List<PreviousEvaluationItemRequest> peir) {
      List<String> errors = new ArrayList<>();
      peir.forEach(item -> {
         if (this.symptomUseCase.findById(item.getSymptomId()).isEmpty()) {
            errors.add("Error sintoma del item, no encontrado id: " + item.getSymptomId());
         }
      });

      if (!errors.isEmpty()) {
         throw new GeneralValidationException("[Error Database, validateSymptomItems] PreviousEvaluationItem", errors);
      }
   }


}
