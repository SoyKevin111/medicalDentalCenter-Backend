package com.example.project.symptom.domain.port.in;

import com.example.project.symptom.domain.Symptom;

import java.util.List;

public interface ISymptomUseCase {

   Symptom create(Symptom symptom);
   List<Symptom> findAll();

}
