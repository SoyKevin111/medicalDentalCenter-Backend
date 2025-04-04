package com.example.project.medicalRecord.application.mapper;

import com.example.project.medicalConsultation.domain.MedicalConsultation;
import com.example.project.medicalConsultation.domain.MedicalConsultationRequest;
import com.example.project.medicalRecord.domain.MedicalRecord;
import com.example.project.medicalRecord.domain.MedicalRecordRequest;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.in.INurseUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.in.IPatientUseCase;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluation;
import com.example.project.previousEvaluation.domain.model.PreviousEvaluationItem;
import com.example.project.previousEvaluation.domain.request.PreviousEvaluationRequest;
import com.example.project.shared.exception.GeneralValidationException;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorUseCase;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.domain.port.in.ISymptomUseCase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MedicalRecordRequestMapper {

   private IPatientUseCase patientUseCase;
   private ISpecialistDoctorUseCase specialistDoctorUseCase;
   private ISymptomUseCase symptomUseCase;
   private INurseUseCase nurseUseCase;

   public MedicalRecordRequestMapper(ISpecialistDoctorUseCase specialistDoctorUseCase, IPatientUseCase patientUseCase, ISymptomUseCase symptomUseCase, INurseUseCase nurseUseCase) {
      this.specialistDoctorUseCase = specialistDoctorUseCase;
      this.patientUseCase = patientUseCase;
      this.symptomUseCase = symptomUseCase;
      this.nurseUseCase = nurseUseCase;
   }

   public MedicalRecord medicalRecordRequestToDomain(MedicalRecordRequest medicalRecordRequest) {
      //validacion de dominio, verificando existencia de cada propiedad y objeto de entrada.
      //buscar paciente registrado
      Patient patient = asignationPatient(medicalRecordRequest.getPatientId());
      MedicalConsultation medicalConsultation = asignationMedicalConsultation(medicalRecordRequest.getMedicalConsultationRequest());
      PreviousEvaluation previousEvaluation =  asignationPreviousEvaluation(medicalRecordRequest.getPreviousEvaluationRequest());

      MedicalRecord medicalRecord = new MedicalRecord();
      medicalRecord.setPatient(patient);
      medicalRecord.setMedicalConsultation(medicalConsultation);
      medicalRecord.setPreviousEvaluation(previousEvaluation);
      return medicalRecord;
   }

   public Patient asignationPatient(Long patientId) {
      Optional<Patient> patient = this.patientUseCase.findById(patientId);
      if (patient.isEmpty()) {
         throw new GeneralValidationException("[Error Database, create] MedicalRecord", List.of("Paciente no encontrado."));
      }
      return patient.get();
   }

   public MedicalConsultation asignationMedicalConsultation(MedicalConsultationRequest mcr) {
      SpecialistDoctor specialistDoctor = this.specialistDoctorUseCase.findById(mcr.getSpecialistDoctorId())
         .orElseThrow(() ->
            new GeneralValidationException("[Erorr database, find]SpecialistDoctor", List.of("No se encontro al medico especialista"))
         );
      return MedicalConsultation.builder()
         .specialistDoctor(specialistDoctor)
         .diagnostic(mcr.getDiagnostic())
         .build();
   }

   public PreviousEvaluation asignationPreviousEvaluation(PreviousEvaluationRequest per){
      PreviousEvaluation previousEvaluation = new PreviousEvaluation();
      List<PreviousEvaluationItem> previousEvaluationItemList = new ArrayList<>();
      per.getPreviousEvaluationItemRequests().forEach(item -> {
         PreviousEvaluationItem previousEvaluationItem = new PreviousEvaluationItem();
         Optional<Symptom> optionalSymptom = this.symptomUseCase.findById(item.getSymptomId());
         optionalSymptom.ifPresent(previousEvaluationItem :: setSymptom);

         previousEvaluationItem.setHasSymptom(item.getHasSymptom());
         previousEvaluationItemList.add(previousEvaluationItem);
      });
      Optional<Nurse> optionalNurse = this.nurseUseCase.getNurseById(per.getNurseId());
      optionalNurse.ifPresent(previousEvaluation::setNurse);
      previousEvaluation.setPreviousEvaluationItemList(previousEvaluationItemList);
      previousEvaluation.setCaseSelected(per.getCaseSelected());

      return previousEvaluation;
   }
}
