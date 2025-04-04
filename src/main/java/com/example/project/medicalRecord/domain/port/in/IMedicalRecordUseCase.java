package com.example.project.medicalRecord.domain.port.in;

import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.MedicalRecordRequest;

import java.util.List;
import java.util.Optional;

public interface IMedicalRecordUseCase {
   MedicalRecord create(MedicalRecordRequest medicalRecordRequest);

   Optional<MedicalRecord> update(MedicalRecordRequest medicalRecordRequest);

   Optional<MedicalRecord> findById(Long id);

   void deleteById(Long id);

   List<MedicalRecord> findAll();
}
