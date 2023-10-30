package com.truedev.ecommerce.controller;

import com.truedev.ecommerce.model.Usuario;
import com.truedev.ecommerce.security.ECToken;
import com.truedev.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

  @Autowired
  private IUsuarioService usuarioService;

  @PostMapping("/usuarios")
  public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario novo) {
    Usuario result = usuarioService.cadastrarNovo(novo);
    if (result != null) {
      return ResponseEntity.status(201).body(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @PutMapping("/usuarios/{id}")
  public ResponseEntity<Usuario> alterarDados(@PathVariable Integer id, @RequestBody Usuario usuario) {
    usuario.setIdUsuario(id);
    Usuario result = usuarioService.alterarDados(usuario);
    if (result != null) {
      return ResponseEntity.ok(result);
    }
    return ResponseEntity.badRequest().build();
  }

  @PostMapping("/login")
  public ResponseEntity<ECToken> realizarLogin(@RequestBody Usuario usuario) {
    ECToken token = usuarioService.fazerLogin(usuario.getLogin(), usuario.getSenha());
    if (token != null) {
      return ResponseEntity.ok(token);
    }
    return ResponseEntity.status(403).build();
  }
}
