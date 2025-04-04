package com.example.project.medicalRecord.domain;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.patient.domain.Patient;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecord {
   Long id;
   Patient patient;
   MedicalConsultation medicalConsultation;
   PreviousEvaluation previousEvaluation;
   LocalDate dateCreated;
}
