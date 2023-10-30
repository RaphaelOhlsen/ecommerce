package com.truedev.ecommerce.service.pedido;

import com.truedev.ecommerce.dto.FaturamentoMensal;
import com.truedev.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {
  public Pedido criarPedido(Pedido novo);
  public Pedido alterarPedido(Pedido pedido);
  public List<Pedido> recuperarTodos();
  public Pedido recuperarPorNumeroPedido(Integer numeroPedido);
  public List<Pedido> recuperarPorStatus(Integer status);
  public List<FaturamentoMensal> recuperarFaturamento(Integer ano);
}
