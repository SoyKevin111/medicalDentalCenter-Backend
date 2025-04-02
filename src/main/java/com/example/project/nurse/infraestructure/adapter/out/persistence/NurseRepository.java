package com.example.project.nurse.infraestructure.adapter.out.persistence;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import com.example.project.nurse.infraestructure.adapter.out.persistence.database.NurseRepositoryMySql;
import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import com.example.project.utils.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NurseRepository implements INurseRepository {

   @Autowired
   private NurseRepositoryMySql nurseRepository;

   @Autowired
   private GeneralMapper generalMapper;


   @Override
   public Optional<Nurse> findById(Long id) {
      return this.nurseRepository.findById(id).map(
         e -> generalMapper.toDomain(e, Nurse.class)
      );
   }

   @Override
   public boolean existsByName(String name) {
      return this.nurseRepository.existsByName(name);
   }

   @Override
   public Nurse findRandomNurse() {
      return this.generalMapper.toDomain(this.nurseRepository.findRandomNurse(), Nurse.class);
   }

   @Override
   public Nurse save(Nurse nurse) {
      NurseEntity nurseEntity = this.nurseRepository.save(this.generalMapper.toEntity(nurse, NurseEntity.class));
      return  this.generalMapper.toDomain(nurseEntity, Nurse.class);
   }

   @Override
   public List<Nurse> findAll() {
      return ((List<NurseEntity>) this.nurseRepository.findAll())
         .stream()
         .map(e -> this.generalMapper.toEntity(e, Nurse.class)).toList();
   }

   @Override
   public boolean existsById(Long id) {
      return this.nurseRepository.existsById(id);
   }
}
