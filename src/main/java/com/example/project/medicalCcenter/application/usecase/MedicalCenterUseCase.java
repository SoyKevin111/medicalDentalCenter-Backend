package com.example.project.medicalCcenter.application.usecase;

import com.example.project.medicalCcenter.domain.IMedicalCenterUseCase;
import com.example.project.medicalCcenter.domain.MedicalCenter;
import org.springframework.stereotype.Service;

@Service
public class MedicalCenterUseCase implements IMedicalCenterUseCase {


   @Override
   public String getMedicalCenterName() {
      MedicalCenter medicalCenter = new MedicalCenter();
      return medicalCenter.getName();
   }
}
