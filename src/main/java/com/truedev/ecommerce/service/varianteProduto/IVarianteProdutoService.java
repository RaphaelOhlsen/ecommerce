package com.truedev.ecommerce.service.varianteProduto;

import com.truedev.ecommerce.model.Produto;
import com.truedev.ecommerce.model.VarianteProduto;

import java.util.List;

public interface IVarianteProdutoService {
  public VarianteProduto adicionarNovaVariante(VarianteProduto nova);
  public VarianteProduto atualizarVariante(VarianteProduto varianteProduto);
  public List<VarianteProduto> recuperarPorProduto (Produto produto);
  public VarianteProduto recuperarPorId (Integer id);
}
