package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
  public List<Pedido> findAllByStatus(Integer status);
}
