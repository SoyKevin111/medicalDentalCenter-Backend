package com.example.project.previousEvaluation.domain.model;
import com.example.project.symptom.domain.Symptom;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluationItem {
   Long id;
   Symptom symptom;
   boolean value;
}
