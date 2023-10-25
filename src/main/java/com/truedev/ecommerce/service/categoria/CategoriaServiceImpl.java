package com.truedev.ecommerce.service.categoria;

import com.truedev.ecommerce.dao.CategoriaDAO;
import com.truedev.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServiceImpl implements ICategoriaService{

  @Autowired
  private CategoriaDAO categoriaDAO;

  @Override
  public Categoria cadastrarNovaCategoria(Categoria nova) {
    return categoriaDAO.save(nova);
  }

  @Override
  public Categoria alterarCategoria(Categoria categoria) {
    return categoriaDAO.save(categoria);
  }

  @Override
  public Categoria recuperarCategoriaPeloId(Integer id) {
    return categoriaDAO.findById(id).orElse(null);
  }

  @Override
  public void apagarCategoria(Integer id) {
      categoriaDAO.deleteById(id);
  }

  @Override
  public List<Categoria> recuperarTodas() {
    return categoriaDAO.findAllByOrderByNomeAsc();
  }
}
