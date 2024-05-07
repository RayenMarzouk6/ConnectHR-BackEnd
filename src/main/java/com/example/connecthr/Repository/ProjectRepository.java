package com.example.connecthr.Repository;

import com.example.connecthr.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
// Trouver des projets par nom
    List<Project> findByName(String name);

    // Trouver des projets par date de début
    List<Project> findByProjectDateDebut(Date projectDateDebut);

    // Trouver des projets par client
  // List<Project> findByClient_Client_id(Integer clientId);

    // Trouver des projets par employé
    @Query("SELECT p FROM Project p JOIN p.employee e WHERE e.employee_id = :employeeId")
    List<Project> findByEmployeeId(Integer employeeId);

    // Trouver des projets actifs (c'est-à-dire qui n'ont pas encore atteint leur date de fin)
    @Query("SELECT p FROM Project p WHERE p.projectDateFin > CURRENT_DATE")
    List<Project> findActiveProjects();
}
