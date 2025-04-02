package com.example.project.nurse.domain.port.in;

import com.example.project.nurse.domain.Nurse;

import java.util.List;
import java.util.Optional;

public interface INurseUseCase {
   Optional<Nurse> getNurseById(Long id);
   Nurse save(Nurse nurse);
   List<Nurse> findAll();
   Nurse findRandomNurse();
   boolean existsById(Long id);
}
