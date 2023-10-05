package com.example.application.controller;

import com.example.application.model.usuarioModel.UsuarioDao;
import com.example.application.model.usuarioModel.UsuarioEnt;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
   private UsuarioDao usuarioDao = new UsuarioDao();

   public List<UsuarioEnt> listUsuario(String nome) {
      List<UsuarioEnt> usuarios = new ArrayList<>();
      return usuarioDao.getByNome(nome);
   }

   public void create(String nome, String senha) {
      List<UsuarioEnt> usuarios = new ArrayList<>();
      usuarioDao.create(nome, senha);
   }
}
