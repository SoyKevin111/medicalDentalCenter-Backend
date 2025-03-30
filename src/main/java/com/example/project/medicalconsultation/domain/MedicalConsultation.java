package com.example.project.medicalconsultation.domain;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalConsultation {
   Long id;
   SpecialistDoctor specialistDoctor;
   String diagnostic;
}
