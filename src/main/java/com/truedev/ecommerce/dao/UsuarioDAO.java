package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
  public Usuario findByLogin(String login);
}
