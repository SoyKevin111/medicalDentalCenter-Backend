package com.example.project.medicalconsultation.infraestructure.adapter.out.persistence.entity;

import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "medical_consultation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalConsultationEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @ManyToOne( cascade = {CascadeType.REFRESH})
   @JoinColumn(name="specialist_doctor_id", referencedColumnName="id", nullable = false)
   SpecialistDoctorEntity specialistDoctorEntity;

   @NotBlank //not null, not only space
   @Column(name = "diagnostic")
   String diagnostic;

}
