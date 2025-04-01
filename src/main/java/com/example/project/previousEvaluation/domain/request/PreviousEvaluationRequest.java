package com.example.project.previousEvaluation.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreviousEvaluationRequest {
   @JsonProperty("items")
   List<PreviousEvaluationItemRequest> previousEvaluationItemRequests;
   Long nurseId;
   String caseDescription;


}

/*
{
   "items": [
      item1,
      item2,
      item3
   ],
   "nurseId": 2,
   "caseDescription":"sdkmsdamkdamkmkd"
}

item: {
   "symptomId": "Fiebre", //por defecto, buscas el id del sintoma
   "value": true
}



*/
