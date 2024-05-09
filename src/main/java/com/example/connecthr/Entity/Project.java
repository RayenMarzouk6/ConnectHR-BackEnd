package com.example.connecthr.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="projet")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L; // Vous pouvez générer un UID spécifique

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Integer project_id ;

    @Column(name="name")
    private String name ;

    @Column(name="description")
    private String description;

    @Column(name = "project_date_debut")
    private Date projectDateDebut ;

    @Column(name = "project_date_fin")
    private Date projectDateFin ;

    @Column(name = "Budget-prix")
    private String Budget ;

    @Column(name = "files")
    private String files ;


    @ManyToOne // Un projet est lié à un seul client
    @JoinColumn(name = "client_id") // Crée une jointure basée sur 'client_id'
    private Client client; // Relation avec 'Client'

    @ManyToMany(mappedBy="projects", cascade = CascadeType.ALL)
    private Set<Employes> employee;
}
