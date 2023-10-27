package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.model.VarianteProduto;
import com.truedev.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.truedev.ecommerce.model.Categoria;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
  private ICategoriaService categoriaService;

  @GetMapping
  public ResponseEntity<List<Categoria>> getAll() {
    List<Categoria> lista = categoriaService.recuperarTodas();
      return ResponseEntity.ok(lista);
  }

  @PostMapping
  public ResponseEntity<Categoria> insertNew(@RequestBody Categoria nova) {
    try {
      Categoria result = categoriaService.cadastrarNovaCategoria(nova);
      if (result != null) {
        return ResponseEntity.status(201).body(result);
      }
    } catch (Exception e) {
      System.out.println("LOG - Erro ao cadastrar categoria - " + e.getMessage());
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
    Categoria result = categoriaService.recuperarCategoriaPeloId(id);

    if (result != null) {
      categoria.setId(id);
      result = categoriaService.alterarCategoria(categoria);
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Integer id) {
    try {
      Categoria result = categoriaService.recuperarCategoriaPeloId(id);

      if (result != null) {
        categoriaService.apagarCategoria(result.getId());
        return ResponseEntity.ok("Removed");
      }
    } catch (Exception e) {
      System.out.println("LOG - Erro ao excluir categoria - " + e.getMessage());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
    Categoria result = categoriaService.recuperarCategoriaPeloId(id);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

}
