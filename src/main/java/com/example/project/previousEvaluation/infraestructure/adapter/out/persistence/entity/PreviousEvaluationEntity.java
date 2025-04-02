package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity;


import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import com.example.project.previousEvaluation.domain.model.CaseSelected;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

   @OneToMany(cascade = {CascadeType.PERSIST})
   @JoinColumn(name = "previous_evaluation_id")
   List<PreviousEvaluationItemEntity> previousEvaluationItemList = new ArrayList<>();

   @ManyToOne(cascade = CascadeType.REFRESH)
   @JoinColumn(name = "nurse_id", referencedColumnName="id", nullable = false)
   NurseEntity nurse;

   @Column(name = "case_selected")
   @Enumerated(EnumType.STRING)
   CaseSelected caseSelected;

}
