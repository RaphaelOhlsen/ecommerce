package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.dto.FaturamentoMensal;
import com.truedev.ecommerce.model.Pedido;
import com.truedev.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private IPedidoService pedidoService;

  @PostMapping
  public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido novo) {
    Pedido result = pedidoService.criarPedido(novo);

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping
  public ResponseEntity<Pedido> alterarPedido(@RequestBody Pedido pedido) {
    Pedido result = pedidoService.alterarPedido(pedido);

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @GetMapping
  public ResponseEntity<List<Pedido>> recuperarTodos() {
    List<Pedido> result = pedidoService.recuperarTodos();

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{numeroPedido}")
  public ResponseEntity<Pedido> recuperarPorNumeroPedido(@PathVariable Integer numeroPedido) {
    Pedido result = pedidoService.recuperarPorNumeroPedido(numeroPedido);

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{status}")
  public ResponseEntity<List<Pedido>> recuperarPorStatus(@PathVariable Integer status) {
    List<Pedido> result = pedidoService.recuperarPorStatus(status);

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/faturamento/{ano}")
  public ResponseEntity<List<FaturamentoMensal>> recuperarFaturamento(@PathVariable Integer ano) {
    System.out.println("Cheguei aqui");
    List<FaturamentoMensal> result = pedidoService.recuperarFaturamento(ano);

    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.notFound().build();
  }
}
