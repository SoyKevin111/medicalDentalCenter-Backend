package com.example.project.medicalConsultation.infraestructure.adapter.out.persistence;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.medicalConsultation.domain.port.out.IMedicalConsultationRepository;
import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.database.MedicalConsultationRepositorySql;
import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import com.example.project.shared.mapper.GeneralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalConsultationRepository implements IMedicalConsultationRepository {

   @Autowired
   MedicalConsultationRepositorySql medicalConsultationRepository;
   @Autowired
   GeneralMapper generalMapper;

   @Override
   public MedicalConsultation save(MedicalConsultation medicalConsultation) { //create, update
      MedicalConsultationEntity mce = this.generalMapper.toEntity(medicalConsultation, MedicalConsultationEntity.class);
      if(medicalConsultation.getSpecialistDoctor() != null){
         mce.setSpecialistDoctorEntity(
            this.generalMapper.toEntity(medicalConsultation.getSpecialistDoctor(), SpecialistDoctorEntity.class)
         );
         return this.generalMapper.toDomain(this.medicalConsultationRepository.save(mce), MedicalConsultation.class);
      }

      return null;
   }

   @Override
   public Optional< MedicalConsultation> findById(Long id) {
      return this.medicalConsultationRepository.findById(id)
         .map(entity ->
            generalMapper.toDomain(entity, MedicalConsultation.class)
         );
   }

   @Override
   public List<MedicalConsultation> findAll() {
      return ((List<MedicalConsultationEntity>) this.medicalConsultationRepository.findAll())
         .stream()
         .map(entity -> generalMapper.toDomain(entity, MedicalConsultation.class)).toList();
   }


   @Override
   public void deleteById(Long id) {
      this.medicalConsultationRepository.deleteById(id);
   }

}
