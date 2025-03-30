package com.example.project.medicalconsultation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalConsultationRequest {

   @JsonProperty("id")
   Long specialistDoctorId;
   @JsonProperty("diagnostic")
   String diagnostic;
}
