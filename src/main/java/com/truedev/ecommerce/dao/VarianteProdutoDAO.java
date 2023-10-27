package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.model.Produto;
import com.truedev.ecommerce.model.VarianteProduto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteProdutoDAO extends CrudRepository<VarianteProduto, Integer> {
  public List<VarianteProduto> findByProduto (Produto produto);
}
