package com.example.project.medicalRecord.domain.port.out;

import com.example.project.medicalRecord.domain.MedicalRecord;

import java.util.List;
import java.util.Optional;

public interface IMedicalRecordRepository {
   MedicalRecord save(MedicalRecord medicalRecord);
   Optional<MedicalRecord> findById(Long id);
   void deleteById(Long id);
   List<MedicalRecord> findAll();
}
