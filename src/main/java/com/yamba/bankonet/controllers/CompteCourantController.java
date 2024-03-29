package com.yamba.bankonet.controllers;

import com.yamba.bankonet.entities.CompteCourant;
import com.yamba.bankonet.exceptions.ResourceNotFoundException;
import com.yamba.bankonet.repo.ICompteCourantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/compte_courant")
public class CompteCourantController {
    @Autowired // This means to get the bean called CompteEpargneRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ICompteCourantRepo repo;

    @GetMapping(path="/{numero}")
    public CompteCourant getCompteEpargneById(@PathVariable String numero){
        return repo.findById(numero)
                .orElseThrow(() -> new ResourceNotFoundException("compte_courant " + numero + " not found"));
    }

    @GetMapping(path="/all")
    public Iterable<CompteCourant> getComptesCourants() {
        return repo.findAll();
    }

    @PostMapping(path="/new")
    public CompteCourant addCompteEpargne(@RequestBody CompteCourant compteCourant) {
        return repo.save(compteCourant);
    }

    @DeleteMapping(path="/{numero}")
    public void deleteClient(@PathVariable String numero) {
        repo.deleteById(numero);
    }


    @PutMapping(path="/{numero}")
    public CompteCourant updateClient(@PathVariable String numero,@RequestBody CompteCourant updatedCompteCourant){
        CompteCourant actualCompteCourant = repo.findById(numero)
                .orElseThrow(() -> new ResourceNotFoundException("compte_courant " + numero + " not found"));
        actualCompteCourant.setIntitule(updatedCompteCourant.getIntitule());
        actualCompteCourant.setSolde(updatedCompteCourant.getSolde());
        actualCompteCourant.setClient(updatedCompteCourant.getClient());
        actualCompteCourant.setDecouvert(updatedCompteCourant.getDecouvert());
        return repo.save(actualCompteCourant);
    }

}
