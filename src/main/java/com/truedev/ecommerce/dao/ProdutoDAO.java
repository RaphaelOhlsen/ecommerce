package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.model.Categoria;
import com.truedev.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

  public List<Produto> findByNomeContaining(String palavraChave);
  public List<Produto> findByOrderByNomeAsc();
  public List<Produto> findByCategoriasContaining(Categoria categoria);
}
