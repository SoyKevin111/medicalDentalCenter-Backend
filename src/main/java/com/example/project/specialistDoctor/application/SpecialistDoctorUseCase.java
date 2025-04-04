package com.example.project.specialistDoctor.application;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorUseCase;
import com.example.project.specialistDoctor.domain.port.out.ISpecialistDoctorRepository;
import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialistDoctorUseCase implements ISpecialistDoctorUseCase {

   @Autowired
   private ISpecialistDoctorRepository specialistDoctorRepository;

   @Transactional()
   @Override
   public SpecialistDoctor create(SpecialistDoctor specialistDoctor) {
      try {
         return this.specialistDoctorRepository.save(specialistDoctor);
      }
      catch (Exception e){
         throw new RuntimeException("Error al guardar el Doctor Especialista: "+e);
      }
   }
   @Transactional(readOnly = true)
   @Override
   public List<SpecialistDoctor> findAllSpecialistDoctor() {
      return (List<SpecialistDoctor>) this.specialistDoctorRepository.findAll();
   }

   @Transactional(readOnly = true)
   @Override
   public Optional<SpecialistDoctor> findById(Long id) {
      Optional<SpecialistDoctor> optionalSpecialistDoctor = this.specialistDoctorRepository.findById(id);
      if(optionalSpecialistDoctor.isEmpty()){
         throw new GeneralValidationException("[Error Database, Find()] SpecialistDoctor",List.of("No se pudo encontrar al medico especialista."));
      }
      return optionalSpecialistDoctor;
   }
}
