package com.yamba.bankonet.repo;

import com.yamba.bankonet.entities.Compte;
import org.springframework.data.repository.CrudRepository;

public interface ICompteRepo extends CrudRepository<Compte, String> {}