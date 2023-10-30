package com.truedev.ecommerce.service.usuario;

import com.truedev.ecommerce.dao.UsuarioDAO;
import com.truedev.ecommerce.model.Usuario;
import com.truedev.ecommerce.security.ECToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

  @Autowired
  private UsuarioDAO usuarioDAO;

  @Override
  public Usuario cadastrarNovo(Usuario novo) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String novaSenha = encoder.encode(novo.getSenha());

    novo.setSenha(novaSenha);
    return usuarioDAO.save(novo);
  }

 @Override
  public Usuario alterarDados(Usuario usuario) {
   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
   String novaSenha = encoder.encode(usuario.getSenha());

   usuario.setSenha(novaSenha);
   return usuarioDAO.save(usuario);

  }

  @Override
    public ECToken fazerLogin(String login, String senha) {
      Usuario usuario = usuarioDAO.findByLogin(login);
      if (usuario != null) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(senha, usuario.getSenha())) {

          return token;
        }
      }
    }

}
