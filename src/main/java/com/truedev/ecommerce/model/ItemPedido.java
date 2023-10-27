package com.truedev.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "tbl_itempedido")
public class ItemPedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "num_seq")
  private Integer numSeq;

  @Column(name = "valor_unitario")
  private Double valorUnitario;

  @Column(name = "quantidade")
  private Integer quantidade;

  @Column(name = "valor_total")
  private Double valorTotal;

  @ManyToOne
  @JoinColumn(name = "numero_pedido")
  @JsonIgnoreProperties("itensPedido")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "id_variante")
  private VarianteProduto varianteProduto;

  public Integer getNumSeq() {
    return numSeq;
  }

  public void setNumSeq(Integer numSeq) {
    this.numSeq = numSeq;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public VarianteProduto getVarianteProduto() {
    return varianteProduto;
  }

  public void setVarianteProduto(VarianteProduto varianteProduto) {
    this.varianteProduto = varianteProduto;
  }
}
