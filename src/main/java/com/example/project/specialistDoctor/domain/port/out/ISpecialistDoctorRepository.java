package com.example.project.specialistDoctor.domain.port.out;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;

import java.util.List;
import java.util.Optional;


public interface ISpecialistDoctorRepository {
   SpecialistDoctor save(SpecialistDoctor specialistDoctor);
   List<SpecialistDoctor> findAll();
   Optional<SpecialistDoctor>  findById(Long id);
}
