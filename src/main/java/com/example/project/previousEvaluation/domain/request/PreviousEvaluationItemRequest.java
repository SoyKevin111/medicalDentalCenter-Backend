package com.example.project.previousEvaluation.domain.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluationItemRequest {
   Long symptomId;
   Boolean hasSymptom;
}

/*
{
   "symptomId": 2, //por defecto, buscas el id del sintoma
   "hasSymptom": true
}

*/