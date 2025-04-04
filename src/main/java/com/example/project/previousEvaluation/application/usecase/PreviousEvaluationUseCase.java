package com.example.project.previousEvaluation.application.usecase;

import com.example.project.nurse.domain.Nurse;
import com.example.project.previousEvaluation.application.validation.PreviousEvaluationUseCaseValidator;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.port.in.IPreviousEvaluationUseCase;
import com.example.project.previousEvaluation.domain.port.out.IPreviousEvaluationRepository;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationItemRequest;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import com.example.project.previousEvaluation.domain.validation.PreviousEvaluationRequestValidator;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PreviousEvaluationUseCase implements IPreviousEvaluationUseCase {

   @Autowired
   private IPreviousEvaluationRepository previousEvaluationRepository;
   @Autowired
   private PreviousEvaluationUseCaseValidator previousEvaluationUseCaseValidator;
   @Autowired
   private PreviousEvaluationRequestValidator previousEvaluationRequestValidator;
   @Autowired
   private ISymptomUseCase symptomUseCase;

   @Transactional
   @Override
   public PreviousEvaluation create(PreviousEvaluationRequest previousEvaluationRequest) { // list items, nurseId, caseDescription
      this.previousEvaluationRequestValidator.createValidator(previousEvaluationRequest);//validacion de dominio
      Optional<Nurse> optionalNurse =  this.previousEvaluationUseCaseValidator.validadorNurse(previousEvaluationRequest.getNurseId()); //validacion enfermera

      List<PreviousEvaluationItem> previousEvaluationList = this.asignationItemList(previousEvaluationRequest.getPreviousEvaluationItemRequests());

      PreviousEvaluation previousEvaluation = new PreviousEvaluation();
      previousEvaluation.setPreviousEvaluationItemList(previousEvaluationList);
      optionalNurse.ifPresent(previousEvaluation::setNurse);
      previousEvaluation.setCaseSelected(previousEvaluationRequest.getCaseSelected());
      return this.previousEvaluationRepository.save(previousEvaluation);
   }

   public List<PreviousEvaluationItem> asignationItemList(List<PreviousEvaluationItemRequest> peirLs){ //e: {Symptom, hasSymptom}
      this.previousEvaluationUseCaseValidator.validationSymptomItems(peirLs);  //validacion existencia de sintomas.
      List<PreviousEvaluationItem> previousEvaluationItemList = new ArrayList<>();
      peirLs.forEach( item -> {
         PreviousEvaluationItem previousEvaluationItem = new PreviousEvaluationItem();
         Optional<Symptom> symptomOptional = symptomUseCase.findById(item.getSymptomId());

         symptomOptional.ifPresent(previousEvaluationItem::setSymptom);
         previousEvaluationItem.setHasSymptom(item.getHasSymptom());
         previousEvaluationItemList.add(previousEvaluationItem); //add to list
      });
      return previousEvaluationItemList;
   }

   @Override
   public List<PreviousEvaluation> findAll() {
      return List.of();
   }

   @Override
   public Optional<PreviousEvaluation> findById(Long id) {
      Optional<PreviousEvaluation> optionalPreviousEvaluation = this.previousEvaluationRepository.findById(id);
      if(optionalPreviousEvaluation.isEmpty()){
         throw new GeneralValidationException("[Error Database, find()] PreviousEvaluation",List.of("No se pudo encontrar la evaluacion previa."));
      }
      return optionalPreviousEvaluation;
   }

   @Override
   public boolean existsById(Long id) {
      return this.previousEvaluationRepository.existsById(id);
   }


}
