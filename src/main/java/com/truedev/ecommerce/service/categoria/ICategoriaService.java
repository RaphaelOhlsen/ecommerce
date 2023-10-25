package com.truedev.ecommerce.service.categoria;

import com.truedev.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {
  public Categoria cadastrarNovaCategoria(Categoria nova);
  public Categoria alterarCategoria(Categoria categoria);
  public Categoria recuperarCategoriaPeloId(Integer id);
  public void apagarCategoria(Integer id);
  public List<Categoria> recuperarTodas();
}
