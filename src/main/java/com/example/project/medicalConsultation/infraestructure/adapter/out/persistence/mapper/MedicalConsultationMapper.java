package com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.mapper;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedicalConsultationMapper {

   private final ModelMapper modelMapper = new ModelMapper();

   public MedicalConsultationEntity toEntity(MedicalConsultation medicalConsultation){
      MedicalConsultationEntity medicalConsultationEntity = this.modelMapper.map(medicalConsultation, MedicalConsultationEntity.class);
      if(medicalConsultation.getSpecialistDoctor() != null ){
         SpecialistDoctorEntity specialistDoctorEntity = modelMapper.map(medicalConsultation.getSpecialistDoctor(), SpecialistDoctorEntity.class);
         medicalConsultationEntity.setSpecialistDoctorEntity(specialistDoctorEntity);
      }
      return medicalConsultationEntity;
   }

}
