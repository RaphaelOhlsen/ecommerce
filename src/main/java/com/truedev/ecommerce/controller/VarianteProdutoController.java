package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.model.Produto;
import com.truedev.ecommerce.model.VarianteProduto;
import com.truedev.ecommerce.service.varianteProduto.IVarianteProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/variantes")
public class VarianteProdutoController {

  @Autowired
  private IVarianteProdutoService varianteProdutoService;

  @PostMapping
  public ResponseEntity<VarianteProduto> insertNew (@RequestBody VarianteProduto nova) {
    VarianteProduto result = varianteProdutoService.adicionarNovaVariante(nova);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<VarianteProduto> update (@PathVariable Integer id, @RequestBody VarianteProduto variante) {
    variante.setId(id);
    VarianteProduto result = varianteProdutoService.atualizarVariante(variante);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping ("/{id}")
  public ResponseEntity<VarianteProduto> getById (@PathVariable Integer id) {
    VarianteProduto result = varianteProdutoService.recuperarPorId(id);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping
  public ResponseEntity<List<VarianteProduto>> recuperarPeloProduto (@RequestParam (name = "id_produto") Integer id) {
    Produto produto = new Produto();
    produto.setId(id);
    List<VarianteProduto> result = varianteProdutoService.recuperarPorProduto(produto);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }
}
