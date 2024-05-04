package com.example.connecthr.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="produit")
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

}
