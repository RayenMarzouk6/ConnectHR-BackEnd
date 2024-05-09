

package com.example.connecthr.Controller;

import com.example.connecthr.Entity.Employes;
import com.example.connecthr.Repository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees") // Base URL for employee-related operations
public class EmployesController {

    @Autowired
    private EmployesRepository employesRepository;

    @GetMapping
    public List<Employes> getAllEmployees() {
        return employesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employes> getEmployeeById(@PathVariable Integer id) {
        Optional<Employes> employee = employesRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employes createEmployee(@RequestBody Employes employee) {
        return employesRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employes> updateEmployee(@PathVariable Integer id, @RequestBody Employes updatedEmployee) {
        if (!employesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEmployee.setEmployee_id(id); // Set ID for the update
        Employes savedEmployee = employesRepository.save(updatedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        // Corrected typo and added necessary brackets
        if (!employesRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Ensure correct braces and method chaining
        }
        employesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

