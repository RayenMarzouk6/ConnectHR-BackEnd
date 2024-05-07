package com.example.connecthr.Repository;

import com.example.connecthr.Entity.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployesRepository extends JpaRepository<Employes, Integer> {
}
