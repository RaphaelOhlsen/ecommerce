package com.truedev.ecommerce.service.varianteProduto;

import com.truedev.ecommerce.model.Produto;
import com.truedev.ecommerce.model.VarianteProduto;
import com.truedev.ecommerce.dao.VarianteProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
;import java.util.List;

@Component
public class VarianteProdutoServiceImpl implements IVarianteProdutoService {

  @Autowired
  private VarianteProdutoDAO varianteProdutoDAO;


  @Override
  public VarianteProduto adicionarNovaVariante(VarianteProduto nova) {
    return varianteProdutoDAO.save(nova);
  }

  @Override
  public VarianteProduto atualizarVariante(VarianteProduto varianteProduto) {
    return varianteProdutoDAO.save(varianteProduto);
  }

  @Override
  public List<VarianteProduto> recuperarPorProduto(Produto produto) {
    return varianteProdutoDAO.findByProduto(produto);
  }

  @Override
  public VarianteProduto recuperarPorId(Integer id) {
    return varianteProdutoDAO.findById(id).orElse(null);
  }
}
