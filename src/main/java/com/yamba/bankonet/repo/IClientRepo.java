package com.yamba.bankonet.repo;

import com.yamba.bankonet.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientRepo extends CrudRepository<Client, Integer> {}
