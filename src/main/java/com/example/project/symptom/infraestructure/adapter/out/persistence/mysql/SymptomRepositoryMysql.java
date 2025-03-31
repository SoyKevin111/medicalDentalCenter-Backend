package com.example.project.symptom.infraestructure.adapter.out.persistence.mysql;

import com.example.project.symptom.domain.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepositoryMysql extends JpaRepository<Symptom, Long> {
}
