package com.truedev.ecommerce.service.produto;

import com.truedev.ecommerce.model.Categoria;
import com.truedev.ecommerce.model.Produto;

import java.util.List;

public interface IProdutoService {
  public Produto cadastrarNovoPoduto(Produto produto);
  public Produto alterarProduto(Produto produto);
  public List<Produto> recuperarTodos();
  public List<Produto> recuperarPorPalavaraChave(String palavraChave);
  public Produto recuperarPorId(int id);
  public List<Produto> recuperarPorCategoria(Categoria categoria);
}
