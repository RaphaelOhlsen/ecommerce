package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

  public Cliente findByTelefone(String telefone);
}
