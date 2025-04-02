package com.example.project.nurse.domain.port.out;

import com.example.project.nurse.domain.Nurse;

import java.util.List;
import java.util.Optional;

public interface INurseRepository {
   Optional<Nurse> findById(Long id);
   boolean existsByName(String name);
   Nurse findRandomNurse();
   Nurse save(Nurse nurse);
   List<Nurse> findAll();
   boolean existsById(Long id);
}
