package com.yamba.bankonet.controllers;
import com.yamba.bankonet.entities.Client;
import com.yamba.bankonet.exceptions.ResourceNotFoundException;
import com.yamba.bankonet.repo.IClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/client")
public class ClientController {
    @Autowired
    private IClientRepo clientRepo;

    @GetMapping(path="/{id}")
    public Client getClientById(@PathVariable int id){
        return clientRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("client " + id + " not found"));
    }

    @GetMapping(path="/all")
    public Iterable<Client> getClients() {
        return clientRepo.findAll();
    }

    @PostMapping(path="/new")
    public Client addClient(@RequestBody Client client) {
        return clientRepo.save(client);
    }

    @DeleteMapping(path="/{id}")
    public void deleteClient(@PathVariable int id) {
        clientRepo.deleteById(id);
    }

    @PutMapping(path="/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client updatedClient){
        Client actualClient = clientRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("client " + id + " not found"));
        actualClient.setNom(updatedClient.getNom());
        actualClient.setPrenom(updatedClient.getPrenom());
        return clientRepo.save(actualClient);
    }


}
