package com.example.project.symptom.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Symptom {
   Long id;
   String name;
}
