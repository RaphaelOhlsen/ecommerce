package com.truedev.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table (name = "tbl_usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Integer idUsuario;

  @Column(name = "nome_usuario", length = 45, nullable = false)
  private String nome;

  @Column(name = "login_usuario", length = 45, unique = true, nullable = false)
  private String login;

  @Column(name = "senha_usuario", length = 45, nullable = false)
  private String senha;

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
