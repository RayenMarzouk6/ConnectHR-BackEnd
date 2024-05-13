package com.example.connecthr.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Client")

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private Integer client_id ;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name="address")
    private String address;

   //    @Column(name="image")
    //private String image;

    @Column(name="image", columnDefinition = "BLOB")
    private byte[] image;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Project> projects;

}
