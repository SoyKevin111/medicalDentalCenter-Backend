package com.example.project.specialistDoctor.infraestructure.adapter.out.persistence;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.out.ISpecialistDoctorRepository;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.database.SpecialistDoctorRepositorySql;
import com.example.project.shared.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialistDoctorRepository implements ISpecialistDoctorRepository {

   @Autowired
   private SpecialistDoctorRepositorySql specialistDoctorRepository;

   @Autowired
   private GeneralMapper generalMapper;

   @Override
   public SpecialistDoctor save(SpecialistDoctor specialistDoctor) {
      SpecialistDoctorEntity specialistDoctorEntity = this.specialistDoctorRepository.save(this.generalMapper.toEntity(specialistDoctor, SpecialistDoctorEntity.class) );
      return this.generalMapper.toDomain(specialistDoctorEntity, SpecialistDoctor.class);
   }

   @Override
   public List<SpecialistDoctor> findAll() {
      return ((List<SpecialistDoctorEntity>) this.specialistDoctorRepository.findAll())
         .stream()
         .map(e ->this.generalMapper.toDomain(e, SpecialistDoctor.class))
         .toList();
   }

   @Override
   public Optional<SpecialistDoctor> findById(Long id) {
      return this.specialistDoctorRepository.findById(id)
         .map(entity -> this.generalMapper.toDomain(entity, SpecialistDoctor.class));
   }
}
