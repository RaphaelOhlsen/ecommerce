package com.truedev.ecommerce.service.produto;

import com.truedev.ecommerce.dao.ProdutoDAO;
import com.truedev.ecommerce.model.Categoria;
import com.truedev.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

  @Autowired
  private ProdutoDAO produtoDAO;

  private static final int TAMANHO_PAGINA = 5;

  @Override
  public Produto cadastrarNovoPoduto(Produto novo) {
    return produtoDAO.save(novo);
  }

  @Override
  public Produto alterarProduto(Produto produto) {
    return produtoDAO.save(produto);
  }

  @Override
  public Page<Produto> recuperarTodos(int numeroPagina) {
    Pageable pageable = PageRequest.of(numeroPagina - 1, TAMANHO_PAGINA);
    return produtoDAO.findByOrderByNomeAsc(pageable);
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
