package com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.database;

import com.example.project.previousEvaluation.infraestructure.adapter.out.persistence.entity.PreviousEvaluationItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreviousEvaluationItemRepositorySql extends JpaRepository<PreviousEvaluationItemEntity, Long> {
}
