package com.example.project.medicalRecord.domain;

import com.example.project.medicalConsultation.domain.MedicalConsultationRequest;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MedicalRecordRequest {
   Long patientId;
   @JsonProperty("medicalConsultation")
   MedicalConsultationRequest medicalConsultationRequest;
   @JsonProperty("previousEvaluation")
   PreviousEvaluationRequest previousEvaluationRequest;
   LocalDate dateCreated; //yy-mm-dd
}


/*

{
   "patientId": 3,
   "medicalConsultation": {
      "specialistDoctorId": 2,
      "diagnostic": "xxdd"
   },
   "previousEvaluation": {
      "items" : [
         {
            "symptomId": 2,
            "hasSymptom": true
         }
      ],
      "nurseId": 2,
      "caseSelected" : "BRACKETS"
   },
   "dateCreated": "2025-04-03"
}

 */
