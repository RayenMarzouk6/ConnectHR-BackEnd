package com.example.connecthr.Repository;

import com.example.connecthr.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Trouver un client par son nom
    List<Client> findByName(String name);

    // Trouver un client par son email

    Client findByEmail(String email);

    // Trouver des clients par une partie du nom (ignorer la casse)
    List<Client> findByNameContainingIgnoreCase(String partOfName);

    // Trouver des clients par numéro de téléphone

    // Trouver des clients avec des projets
    @Query("SELECT DISTINCT c FROM Client c JOIN c.projects p") // Utilisez JOIN pour vérifier s'il y a des projets
    List<Client> findClientsWithProjects();


    //Image
  //  List<Client> findByOrderById() ;
}
