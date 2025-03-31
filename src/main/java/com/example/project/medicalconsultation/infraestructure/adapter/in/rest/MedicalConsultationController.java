package com.example.project.medicalconsultation.infraestructure.adapter.in.rest;

import com.example.project.medicalconsultation.application.MedicalConsultationUseCase;
import com.example.project.medicalconsultation.domain.MedicalConsultation;
import com.example.project.medicalconsultation.domain.MedicalConsultationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-center/service/medical-consultations")
public class MedicalConsultationController {
   @Autowired
   MedicalConsultationUseCase medicalConsultationUseCase;

   @PostMapping
   public ResponseEntity<?> create(@RequestBody MedicalConsultationRequest medicalConsultationRequest){ {}
      Optional<MedicalConsultation> medicalConsultation =  this.medicalConsultationUseCase.create(medicalConsultationRequest);
      if(medicalConsultation.isEmpty()){
         return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok().body(medicalConsultation);
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> update(@RequestBody MedicalConsultationRequest medicalConsultationRequest, @PathVariable Long id){
      Optional<MedicalConsultation> medicalConsultation = this.medicalConsultationUseCase.update(medicalConsultationRequest, id);
      if(medicalConsultation.isEmpty()){
         return ResponseEntity.badRequest().build();
      }

      return ResponseEntity.ok().body(medicalConsultation);
   }

   @GetMapping
   public List<MedicalConsultation> findAll(){
      return this.medicalConsultationUseCase.findAll();
   }


   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id){
      this.medicalConsultationUseCase.deleteById(id);
   }

}
