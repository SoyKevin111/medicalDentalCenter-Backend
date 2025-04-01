package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.database;

import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreviousEvaluationRepositorySql extends JpaRepository<PreviousEvaluationEntity, Long> {
}
