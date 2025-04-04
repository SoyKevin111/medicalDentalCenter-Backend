package com.example.project.medicalRecord.infraestructure.adapter.in.rest;

import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.MedicalRecordRequest;
import com.example.project.medicalRecord.domain.port.in.IMedicalRecordUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-center/service/medical-record")
public class MedicalRecordController {

   @Autowired
   IMedicalRecordUseCase medicalRecordUseCase;

   @PostMapping
   public ResponseEntity<?> create(@RequestBody MedicalRecordRequest medicalRecordRequest){
      MedicalRecord medicalRecord=  this.medicalRecordUseCase.create(medicalRecordRequest);
      if(medicalRecord != null){
         return ResponseEntity.ok().body(medicalRecord);
      }
      return ResponseEntity.badRequest().build();
   }
}
