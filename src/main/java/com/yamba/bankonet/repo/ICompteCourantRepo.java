package com.yamba.bankonet.repo;

import com.yamba.bankonet.entities.CompteCourant;
import org.springframework.data.repository.CrudRepository;

public interface ICompteCourantRepo extends CrudRepository<CompteCourant, String> {}
