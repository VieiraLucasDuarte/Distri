package com.example.application.views.main;

import com.example.application.controller.UsuarioController;
import com.example.application.model.usuarioModel.UsuarioEnt;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Route("login")
public class LoginView extends Composite<LoginOverlay> {
    public LoginView() {
       LoginOverlay loginOverlay = getContent();
       loginOverlay.setTitle("Distribuidora");
       loginOverlay.setOpened(true);
//Validar Usuario e passar para a proxima tela
       String nome = "Lucas";
       String senha = "123";
       loginOverlay.addLoginListener(event -> {
          //pegar valor do input e da denha
          validaUsuario(nome, senha);
       });
    }


    private boolean validaUsuario(String nome, String senha) {
       UsuarioController con = new UsuarioController();
       UsuarioEnt usu = con.listUsuario(nome).get(0);
       if(usu.getNome() == "nome"){
          if(usu.getSenha() == senha)
             return true;
          else return false;
       }
       else
          return false;
    }
}
