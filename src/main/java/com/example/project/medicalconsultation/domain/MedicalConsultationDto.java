package com.example.project.medicalconsultation.domain;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalConsultationDto {
   SpecialistDoctor specialistDoctor;
   String diagnostic;
}
