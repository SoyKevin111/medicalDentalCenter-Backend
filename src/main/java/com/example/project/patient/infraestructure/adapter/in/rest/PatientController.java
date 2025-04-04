package com.example.project.patient.infraestructure.adapter.in.rest;

import com.example.project.patient.application.usecase.PatientUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-center/staff/patients")
public class PatientController {

   @Autowired
   private PatientUseCase patientUseCase;

   @PutMapping("/{id}")
   public ResponseEntity<?> update(@RequestBody PatientRequest patientRequest, @PathVariable Long id){
     Optional<Patient> optionalPatient = this.patientUseCase.update(patientRequest, id);
       if(optionalPatient.isPresent()){
         return ResponseEntity.ok(optionalPatient.get());
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error","Hubo un error al actualizar el paciente."));
   }

   @PostMapping
   public ResponseEntity<?> create(@RequestBody PatientRequest patientRequest){
      return ResponseEntity.status(HttpStatus.CREATED).body(this.patientUseCase.save(patientRequest));
   }

   @GetMapping
   public List<Patient> findAll(){
      return this.patientUseCase.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<Patient> optionalPatient = this.patientUseCase.findById(id);
      if(optionalPatient.isPresent()){
         return ResponseEntity.status(HttpStatus.OK).body(optionalPatient.get());
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error","Hubo un error al obtener el paciente."));

   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id) {
      this.patientUseCase.delete(id);
   }
}
