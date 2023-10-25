package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.model.Cliente;
import com.truedev.ecommerce.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private IClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<Cliente>> getAll() {
    List<Cliente> lista = clienteService.recuperarTodos();
      return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
    Cliente result = clienteService.recuperarClientePeloId(id);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo) {
    try {
      Cliente result = clienteService.cadastrarNovoCliente(novo);
      if (result != null) {
        return ResponseEntity.status(201).body(result);
      }
    } catch (Exception e) {
      System.out.println("LOG - Erro ao cadastrar cliente - " + e.getMessage());
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping("/busca")
  public ResponseEntity<Cliente> getByTelefone(@RequestParam(name = "telefone") String telefone) {
    Cliente result = clienteService.recuperarClientePeloTelefone(telefone);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
    try {
      Cliente result = clienteService.recuperarClientePeloId(id);

      if (result != null) {
        cliente.setId(id);
        result = clienteService.alterarCliente(cliente);
        return ResponseEntity.ok(result);
      }
    } catch (Exception e) {
      System.out.println("LOG - Erro ao atualizar - " + e.getMessage());
    }
    return ResponseEntity.badRequest().build();
  }


}
