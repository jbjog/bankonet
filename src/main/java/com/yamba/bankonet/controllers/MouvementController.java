package com.yamba.bankonet.controllers;

import com.yamba.bankonet.entities.Client;
import com.yamba.bankonet.entities.Compte;
import com.yamba.bankonet.entities.Mouvement;
import com.yamba.bankonet.exceptions.ResourceNotFoundException;
import com.yamba.bankonet.repo.ICompteRepo;
import com.yamba.bankonet.repo.IMouvementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/mouvement")
public class MouvementController {
    @Autowired
    private IMouvementRepo mouvementRepo;

    @Autowired
    private ICompteRepo compteRepo;

    @GetMapping(path="/compte/{numero}")
    public List<Mouvement> getMouvementsByCompte(@PathVariable String numero){
        Compte cpt = compteRepo.findById(numero)
                .orElseThrow(() -> new ResourceNotFoundException("Compte " + numero + " not found"));
        return mouvementRepo.findMouvementByCompteCredite(cpt);
    }
    @PostMapping(path="/new")
    public Mouvement addMouvement(@RequestBody Mouvement mouvement) {
        return mouvementRepo.save(mouvement);
    }
}
