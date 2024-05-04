package com.example.connecthr.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="Client")

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="client_id")
    private Integer client_id ;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private Integer number;

    @Column(name="address")
    private String address;

    @Column(name="image")
    private String image;


}
