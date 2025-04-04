package com.example.project.medicalRecord.infraestructure.adapter.out.persistence.mapper;

import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.mapper.MedicalConsultationMapper;
import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.infraestructure.adapter.out.persistence.entity.MedicalRecordEntity;
import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.mapper.PreviousEvaluationMapper;
import com.example.project.shared.mapper.GeneralMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordMapper {

   private final ModelMapper modelMapper = new ModelMapper();
   @Autowired
   MedicalConsultationMapper medicalConsultationMapper;
   @Autowired
   PreviousEvaluationMapper previousEvaluationMapper;
   @Autowired
   GeneralMapper generalMapper;

   public MedicalRecordEntity toEntity(MedicalRecord medicalRecord){
      MedicalRecordEntity medicalRecordEntity = this.modelMapper.map(medicalRecord, MedicalRecordEntity.class);
      PatientEntity patientEntity = this.generalMapper.toEntity(medicalRecord.getPatient(), PatientEntity.class);
      MedicalConsultationEntity medicalConsultationEntity = this.medicalConsultationMapper.toEntity(medicalRecord.getMedicalConsultation());
      PreviousEvaluationEntity previousEvaluationEntity = this.previousEvaluationMapper.toEntity(medicalRecord.getPreviousEvaluation());
      medicalRecordEntity.setPatient(patientEntity);
      medicalRecordEntity.setMedicalConsultation(medicalConsultationEntity);
      medicalRecordEntity.setPreviousEvaluation(previousEvaluationEntity);
      return medicalRecordEntity;
   }
}
