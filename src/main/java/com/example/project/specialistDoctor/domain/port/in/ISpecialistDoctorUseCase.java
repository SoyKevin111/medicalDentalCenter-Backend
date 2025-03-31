package com.example.project.specialistDoctor.domain.port.in;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;

import java.util.List;
import java.util.Optional;

public interface ISpecialistDoctorUseCase {

   SpecialistDoctor create(SpecialistDoctor specialistDoctor);
   List<SpecialistDoctor> findAllSpecialistDoctor();
   Optional<SpecialistDoctor> findById(Long id);

}
