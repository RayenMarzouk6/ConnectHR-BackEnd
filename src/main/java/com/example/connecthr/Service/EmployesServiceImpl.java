package com.example.connecthr.Service;

import com.example.connecthr.Entity.Employes;
import com.example.connecthr.Repository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployesServiceImpl implements IEmployesService {
    @Autowired
    private EmployesRepository employesRepository;

    @Override
    public List<Employes> getAllEmployees() {
        return employesRepository.findAll();
    }

    @Override
    public Optional<Employes> getEmployeeById(Integer id) {
        return employesRepository.findById(id);
    }

    @Override
    public Employes saveEmployee(Employes employee) {
        return employesRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employesRepository.deleteById(id);
    }
}
