package com.example.project.medicalRecord.domain.application.usecase;

import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.MedicalRecordRequest;
import com.example.project.medicalRecord.domain.port.in.IMedicalRecordUseCase;
import com.example.project.medicalRecord.domain.port.out.IMedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordUseCase  implements IMedicalRecordUseCase {

   private IMedicalRecordRepository medicalRecordRepository;

   public MedicalRecordUseCase(IMedicalRecordRepository medicalRecordRepository) {
      this.medicalRecordRepository = medicalRecordRepository;
   }

   @Override
   public MedicalRecord create(MedicalRecordRequest medicalRecordRequest) {
      return null;
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
