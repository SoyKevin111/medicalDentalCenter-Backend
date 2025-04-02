package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity;

import com.example.project.symptom.domain.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "previous_evaluation_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluationItemEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @OneToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "symptom_id", referencedColumnName = "id", nullable = false)
   Symptom symptom;

   @NotNull
   @Column(name = "has_symptom")
   Boolean hasSymptom;
}
