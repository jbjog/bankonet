package com.yamba.bankonet.repo;

import com.yamba.bankonet.entities.Compte;
import com.yamba.bankonet.entities.Mouvement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMouvementRepo extends CrudRepository<Mouvement, Integer> {
    public List<Mouvement> findMouvementByCompteCredite(Compte compteCredite);
        public List<Mouvement> findMouvementByCompteDebite(Compte compteDebite);
}
