package com.example.application.model.usuarioModel;

import com.example.application.model.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
   private Connection connection;

   public UsuarioDao() {
      try {
         this.connection = ConnectionFactory.getConnection();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }

   private List<UsuarioEnt> Convert(String sql) {

      List<UsuarioEnt> usuarios = new ArrayList<>();
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
         ResultSet resultSet = preparedStatement.executeQuery();

         while (((ResultSet) resultSet).next()) {
            UsuarioEnt usuario = new UsuarioEnt();
            usuario.setId(resultSet.getLong("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setSenha(resultSet.getString("senha"));
            usuarios.add(usuario);
         }
      } catch (SQLException e) {
         throw new RuntimeException("Erro ao buscar produtos no banco de dados: " + e.getMessage());
      }
      return usuarios;
   }

   public List<UsuarioEnt> getUsuario() {
      String sql = "SELECT * FROM Usuario";
      return Convert(sql);
   }

   public List<UsuarioEnt> getUsuarioByNome(String nome) {
      String sql = "SELECT * FROM Usuario where " + "Nome = " + nome;
      return Convert(sql);
   }
}
