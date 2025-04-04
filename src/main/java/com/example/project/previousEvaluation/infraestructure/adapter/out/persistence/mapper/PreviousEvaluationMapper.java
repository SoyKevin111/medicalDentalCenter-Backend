package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.mapper;

import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PreviousEvaluationMapper {
   private final ModelMapper modelMapper = new ModelMapper();

   public PreviousEvaluationEntity toEntity(PreviousEvaluation previousEvaluation) {
      PreviousEvaluationEntity previousEvaluationEntity = this.modelMapper.map(previousEvaluation, PreviousEvaluationEntity.class);
      List<PreviousEvaluationItemEntity> previousEvaluationItemEntities = new ArrayList<>();
      previousEvaluation.getPreviousEvaluationItemList().forEach(item -> {
         PreviousEvaluationItemEntity previousEvaluationItem = this.modelMapper.map(item, PreviousEvaluationItemEntity.class);
         //symtom ya es de JPA, solo que no le puse el subfijo Entity xd.
         previousEvaluationItemEntities.add(previousEvaluationItem);
      });
      previousEvaluationEntity.setPreviousEvaluationItemList(previousEvaluationItemEntities);
      if (previousEvaluationEntity.getNurse() != null) {
         NurseEntity nurseEntity = this.modelMapper.map(previousEvaluation.getNurse(), NurseEntity.class);
         previousEvaluationEntity.setNurse(nurseEntity);
      }

      return previousEvaluationEntity;
   }

}
