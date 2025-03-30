package com.example.project.nurse.infraestructure.adapter.out.persistence.database;

import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NurseRepositoryMySql extends JpaRepository<NurseEntity, Long> {
   @Query(value = "SELECT * FROM nurse ORDER BY RAND() LIMIT 1", nativeQuery = true)
   NurseEntity findRandomNurse();

   boolean existsByName(String name);

}
