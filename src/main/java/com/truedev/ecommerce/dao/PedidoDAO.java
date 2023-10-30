package com.truedev.ecommerce.dao;

import com.truedev.ecommerce.dto.FaturamentoMensal;
import com.truedev.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
  public List<Pedido> findAllByStatus(Integer status);

  /* criando um query customizada para recuperar faturamento mensal */
  @Query("SELECT new "
      + "com.truedev.ecommerce.dto.FaturamentoMensal(month(p.data), sum(p.valorTotal)) "
      + "FROM Pedido p "
      + "WHERE year(p.data) = :ano "
      + "GROUP BY month(p.data)")
  public List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);
}
