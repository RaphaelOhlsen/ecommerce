package com.truedev.ecommerce.service.produto;

import com.truedev.ecommerce.dao.ProdutoDAO;
import com.truedev.ecommerce.model.Categoria;
import com.truedev.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

  @Autowired
  private ProdutoDAO produtoDAO;

  @Override
  public Produto cadastrarNovoPoduto(Produto novo) {
    return produtoDAO.save(novo);
  }

  @Override
  public Produto alterarProduto(Produto produto) {
    return produtoDAO.save(produto);
  }

  @Override
  public List<Produto> recuperarTodos() {
    return produtoDAO.findByOrderByNomeAsc();
  }

  @Override
  public List<Produto> recuperarPorPalavaraChave(String palavraChave) {
    return produtoDAO.findByNomeContaining(palavraChave);
  }

  @Override
  public Produto recuperarPorId(int id) {
    return produtoDAO.findById(id).orElse(null);
  }

  @Override
  public List<Produto> recuperarPorCategoria(Categoria categoria) {
    return produtoDAO.findByCategoriasContaining(categoria);
  }
}
