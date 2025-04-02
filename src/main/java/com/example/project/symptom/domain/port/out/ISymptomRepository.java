package com.example.project.symptom.domain.port.out;

import com.example.project.symptom.domain.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {
   Symptom save(Symptom symptom);
   List<Symptom> findAll();
   Optional<Symptom> findById(Long id);
}
