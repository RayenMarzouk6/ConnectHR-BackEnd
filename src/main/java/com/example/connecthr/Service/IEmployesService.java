package com.example.connecthr.Service;

import com.example.connecthr.Entity.Employes;

import java.util.List;
import java.util.Optional;

public interface IEmployesService {
    List<Employes> getAllEmployees();

    Optional<Employes> getEmployeeById(Integer id);

    Employes saveEmployee(Employes employee);

    void deleteEmployee(Integer id);
}
