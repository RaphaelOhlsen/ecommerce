package com.truedev.ecommerce.service.pedido;

import com.truedev.ecommerce.dao.PedidoDAO;
import com.truedev.ecommerce.model.ItemPedido;
import com.truedev.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService {

  @Autowired
  private PedidoDAO pedidoDAO;

  @Override
  public Pedido criarPedido(Pedido novoPedido) {
    novoPedido.setStatus(1); // 1 = aguardando pagamento
    // preciso setar o pedido para cada itemPedido
    for (ItemPedido itemPedido: novoPedido.getItensPedido()) {
      itemPedido.setPedido(novoPedido);
    }

    // totalizar o pedido pelo valor dos itens e aplicar o desconto
    double valorTotal;
    double desconto = 0.0;

    valorTotal = novoPedido.getItensPedido().stream()
      .mapToDouble(ItemPedido::getValorTotal)
      .sum();

    novoPedido.setValorBruto(valorTotal);

    if (valorTotal >= 70) {
      desconto = valorTotal * 0.10;
    }
    valorTotal -= desconto;
    novoPedido.setDesconto(desconto);
    novoPedido.setValorTotal(valorTotal);

    return pedidoDAO.save(novoPedido);
  }

  @Override
  public Pedido alterarPedido(Pedido pedido) {
    return pedidoDAO.save(pedido);
  }

  @Override
  public List<Pedido> recuperarTodos() {
    return (List<Pedido>)pedidoDAO.findAll();
  }

  @Override
  public Pedido recuperarPorNumeroPedido(Integer numeroPedido) {
    return pedidoDAO.findById(numeroPedido).orElse(null);
  }

  @Override
  public List<Pedido> recuperarPorStatus(Integer status) {
    return pedidoDAO.findAllByStatus(status);
  }
}
