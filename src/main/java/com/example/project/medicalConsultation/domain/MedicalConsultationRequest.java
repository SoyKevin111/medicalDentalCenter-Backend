package com.example.project.medicalConsultation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConsultationRequest {

   Long id;
   @JsonProperty("specialistDoctorId")
   Long specialistDoctorId;
   @JsonProperty("diagnostic")
   String diagnostic;

}

/*
 {
   "specialistDoctorId" : 2,
   "diagnostic" : "nuevo diagnostico"
 }
 */
