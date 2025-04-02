package com.example.project.previousEvaluation.domain.model;

import com.example.project.nurse.domain.Nurse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluation {
   Long id;
   List<PreviousEvaluationItem> previousEvaluationItemList;
   Nurse nurse;
   CaseSelected caseSelected;
}

