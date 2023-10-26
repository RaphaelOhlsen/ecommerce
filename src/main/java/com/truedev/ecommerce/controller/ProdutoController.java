package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.model.Categoria;
import com.truedev.ecommerce.model.Produto;
import com.truedev.ecommerce.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private IProdutoService produtoService;

  @GetMapping
  public ResponseEntity<List<Produto>> getAll() {
    List<Produto> lista = produtoService.recuperarTodos();
      return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> getById(@PathVariable Integer id) {
    Produto result = produtoService.recuperarPorId(id);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Produto> insertNew(@RequestBody Produto novo) {
    Produto result = produtoService.cadastrarNovoPoduto(novo);
    if (result != null) {
      return ResponseEntity.status(201).body(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto) {
    produto.setId(id);
    Produto result = produtoService.alterarProduto(produto);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/busca")
  public ResponseEntity<List<Produto>> searchByKeyword(@RequestParam(name="keyword") String keyword) {
    List<Produto> lista = produtoService.recuperarPorPalavaraChave(keyword);
    if (lista.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/busca/categoria/{id}")
  public ResponseEntity<List<Produto>> searchByCategory(@PathVariable Integer id) {
    Categoria categoria = new Categoria();
    categoria.setId(id);
    return ResponseEntity.ok(produtoService.recuperarPorCategoria(categoria));
  }
}
