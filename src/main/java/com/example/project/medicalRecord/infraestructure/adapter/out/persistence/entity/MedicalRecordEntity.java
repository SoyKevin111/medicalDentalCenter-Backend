package com.example.project.medicalRecord.infraestructure.adapter.out.persistence.entity;

import com.example.project.medicalConsultation.infraestructure.adapter.out.persistence.entity.MedicalConsultationEntity;
import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecordEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
   PatientEntity patient;

   @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinColumn(name = "medical_consultation_id", referencedColumnName = "id", nullable = false)
   MedicalConsultationEntity medicalConsultation;

   @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   @JoinColumn(name = "previous_evaluation_id", referencedColumnName = "id", nullable = false)
   PreviousEvaluationEntity previousEvaluation;

   @Column(name = "date_created")
   LocalDate dateCreated;
}
