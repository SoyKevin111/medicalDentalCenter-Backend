package com.example.project.medicalRecord.application.usecase;

import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.MedicalRecordRequest;
import com.example.project.medicalRecord.application.mapper.MedicalRecordRequestMapper;
import com.example.project.medicalRecord.domain.port.in.IMedicalRecordUseCase;
import com.example.project.medicalRecord.domain.port.out.IMedicalRecordRepository;
import com.example.project.patient.domain.port.in.IPatientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordUseCase  implements IMedicalRecordUseCase {

   @Autowired
   private IMedicalRecordRepository medicalRecordRepository;
   @Autowired
   private MedicalRecordRequestMapper medicalRecordRequestMapper;
   @Autowired
   private IPatientUseCase patientUseCase;

   @Transactional
   @Override
   public MedicalRecord create(MedicalRecordRequest medicalRecordRequest) {
       //pondre validaciones de dominia
      MedicalRecord medicalRecord = this.medicalRecordRequestMapper.medicalRecordRequestToDomain(medicalRecordRequest);
         try {
            return this.medicalRecordRepository.save(medicalRecord);
         }
         catch (Exception e) {
            throw new RuntimeException("Error al guardar la ficha Medica."+ e.getMessage());
         }
   }

   @Override
   public Optional<MedicalRecord> update(MedicalRecordRequest medicalRecordRequest) {
      return Optional.empty();
   }

   @Override
   public Optional<MedicalRecord> findById(Long id) {
      return Optional.empty();
   }

   @Override
   public void deleteById(Long id) {

   }
   @Override
   public List<MedicalRecord> findAll() {
      return List.of();
   }
}
