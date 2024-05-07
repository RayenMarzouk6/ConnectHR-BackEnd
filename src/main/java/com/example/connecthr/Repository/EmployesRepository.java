package com.example.connecthr.Repository;

import com.example.connecthr.Entity.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer> {

    // Trouver des employés par nom
    List<Employes> findByName(String name);

    // Trouver des employés par email
    Employes findByEmail(String email);

    // Trouver des employés par une compétence
    List<Employes> findBySkillsContaining(String skill);

    // Trouver des employés travaillant sur un projet spécifique
    @Query("SELECT e FROM Employes e JOIN e.projects p WHERE p.project_id = :projectId")
    List<Employes> findByProjectId(Integer projectId);
}
