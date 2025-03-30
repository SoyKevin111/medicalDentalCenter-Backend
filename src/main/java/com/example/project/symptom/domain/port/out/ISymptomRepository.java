package com.example.project.symptom.domain.port.out;

import com.example.project.symptom.domain.Symptom;

import java.util.List;

public interface ISymptomRepository {
   Symptom save(Symptom symptom);
   List<Symptom> findAll();
}
