package com.example.project.medicalCcenter.domain;

public class MedicalCenter {

   Long id;
   String name = "HNA Dental Center";

   public MedicalCenter() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
