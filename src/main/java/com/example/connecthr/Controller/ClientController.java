package com.example.connecthr.Controller;


import com.example.connecthr.Entity.Client;
import com.example.connecthr.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/clients") // Base URL for client-related operations
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/getAll")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    @PostMapping("/createe")
    public Client createClient(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("address") String address) throws IOException {
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setAddress(address);
        client.setImage(file.getBytes()); // Convertir l'image en tableau d'octets
        return clientRepository.save(client);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client updatedClient) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedClient.setClient_id(id); // Set ID for the update
        Client savedClient = clientRepository.save(updatedClient);
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
