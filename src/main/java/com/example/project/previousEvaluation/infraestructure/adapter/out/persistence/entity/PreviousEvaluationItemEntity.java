package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity;

import com.example.project.symptom.infraestructure.adapter.out.persistence.entity.SymptomEntity;
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

   @ManyToOne(cascade = CascadeType.REFRESH)
   @JoinColumn(name = "symptom_id", referencedColumnName = "id", nullable = false)
   SymptomEntity symptom;

   @NotNull
   @Column(name = "has_symptom")
   Boolean hasSymptom;
}
