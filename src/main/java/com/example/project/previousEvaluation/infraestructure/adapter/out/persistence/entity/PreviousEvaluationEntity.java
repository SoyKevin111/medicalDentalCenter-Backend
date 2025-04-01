package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity;


import com.example.project.nurse.domain.Nurse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "previous_evaluation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluationEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @OneToMany(cascade = CascadeType.MERGE)
   @JoinColumn(name = "previous_evaluation_id")
   List<PreviousEvaluationItemEntity> previousEvaluationItemList;

   @OneToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "nurse_id", referencedColumnName="id", nullable = false)
   Nurse nurse;

   @Column(name = "case_description")
   String caseDescription;
}
