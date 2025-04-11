package com.example.project.symptom.infraestructure.adapter.out.persistence.database;

import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.infraestructure.adapter.out.persistence.entity.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepositoryMysql extends JpaRepository<SymptomEntity, Long> {
}
