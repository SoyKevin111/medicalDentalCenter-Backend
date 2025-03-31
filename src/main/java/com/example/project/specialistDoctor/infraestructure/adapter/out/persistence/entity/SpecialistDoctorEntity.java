package com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

//@JsonIgnoreProperties("specialistDoctorEntity")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specialist_doctor")
@Builder
public class SpecialistDoctorEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @Column(name = "name", unique = true)
   String name;

   @Column(name = "specialty")
   String specialty;



}
