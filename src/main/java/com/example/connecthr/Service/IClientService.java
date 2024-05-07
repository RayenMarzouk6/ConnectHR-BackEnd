package com.example.connecthr.Service;

import com.example.connecthr.Entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> getAllClients();

    Optional<Client> getClientById(Integer id);

    Client saveClient(Client client);

    void deleteClient(Integer id);
}
