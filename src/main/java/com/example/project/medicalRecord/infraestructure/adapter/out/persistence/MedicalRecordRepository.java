package com.example.project.medicalRecord.infraestructure.adapter.out.persistence;

import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.port.out.IMedicalRecordRepository;
import com.example.project.medicalRecord.infraestructure.adapter.out.persistence.database.MedicalRecordRepositorySql;
import com.example.project.medicalRecord.infraestructure.adapter.out.persistence.entity.MedicalRecordEntity;
import com.example.project.medicalRecord.infraestructure.adapter.out.persistence.mapper.MedicalRecordMapper;
import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import com.example.project.shared.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalRecordRepository implements IMedicalRecordRepository {

   @Autowired
   private MedicalRecordRepositorySql medicalRecordRepository;
   @Autowired
   private GeneralMapper generalMapper;
   @Autowired
   private MedicalRecordMapper medicalRecordMapper;

   @Override
   public MedicalRecord save(MedicalRecord medicalRecord) { //patient, medicalConsultation,previousEvaluation, dateCrea
      MedicalRecordEntity medicalRecordEntity = this.medicalRecordMapper.toEntity(medicalRecord);
      medicalRecordEntity.setDateCreated();
      return this.generalMapper.toDomain(this.medicalRecordRepository.save(medicalRecordEntity), MedicalRecord.class);
   }

   @Override
   public Optional<MedicalRecord> findById(Long id) {
      return this.medicalRecordRepository.findById(id).map(
         entity -> this.generalMapper.toDomain(entity, MedicalRecord.class)
      );
   }

   @Override
   public void deleteById(Long id) {
      this.medicalRecordRepository.deleteById(id);
   }

   @Override
   public List<MedicalRecord> findAll() {
      return ((List<MedicalRecordEntity>) this.medicalRecordRepository.findAll() )
         .stream()
         .map(
            entity -> this.generalMapper.toDomain(entity, MedicalRecord.class)
         ).toList();
   }

   public MedicalRecordEntity medicalRecordToEntity(MedicalRecord medicalRecord){
      MedicalRecordEntity medicalRecordEntity = this.generalMapper.toEntity(medicalRecord,MedicalRecordEntity.class);
      medicalRecordEntity.setPatient(
         this.generalMapper.toEntity(medicalRecord.getPatient(), PatientEntity.class)
      );
      medicalRecordEntity.setPreviousEvaluation(
         this.generalMapper.toEntity(medicalRecord.getPreviousEvaluation(), PreviousEvaluationEntity.class)
      );
      medicalRecordEntity.setMedicalConsultation(
         this.generalMapper.toEntity(medicalRecord.getMedicalConsultation(), MedicalConsultationEntity.class)
      );
      medicalRecordEntity.setDateCreated(medicalRecord.getDateCreated());

      return medicalRecordEntity;
   }
}
