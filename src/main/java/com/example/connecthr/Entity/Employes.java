package com.example.connecthr.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")
public class Employes implements Serializable {
    private static final long serialVersionUID = 1L; // Vous pouvez générer un UID spécifique
    @Id
    @Column(name="employee_id")
    @GeneratedValue
    private Integer employee_id;

    @Column(name = "name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="number")
    private String number;

    @Column(name="password")
    private String password ;

    // Nouvelle collection de compétences
    @ElementCollection // : Indique que cet attribut est une collection d'éléments simples (plutôt que des entités liées)
    @CollectionTable(name = "EmployeeSkills", joinColumns = @JoinColumn(name = "employee_id")) // Indique le nom de la table où ces éléments seront stockés. Ici, "EmployeeSkills" est le nom de la table, et elle sera liée à l'entité "Employee" par la colonne "employee_id".
    @Column(name = "skill")
    private List<String> skills;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Project> projects;


}
