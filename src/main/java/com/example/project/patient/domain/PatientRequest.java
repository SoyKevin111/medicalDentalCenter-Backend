package com.example.project.patient.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
   String name;
   String surname;
   Gender gender;
   String identification;
   int age;
}
