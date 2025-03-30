package com.example.project.symptom.infraestructure.adapter.in.rest;

import com.example.project.symptom.application.SymptomUseCase;
import com.example.project.symptom.domain.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-center/process/diagnostics")
public class SymptomController {

   @Autowired
   private SymptomUseCase symptomUseCase;

   @GetMapping
   public List<Symptom> findAll(){
      return this.symptomUseCase.findAll();
   }

   @PostMapping
   public ResponseEntity<Symptom> create(@RequestBody Symptom symptom){
      return ResponseEntity.status(HttpStatus.CREATED).body(this.symptomUseCase.create(symptom));
   }

}
