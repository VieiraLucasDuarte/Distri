package com.example.application.model.pedidoModel;

import com.example.application.model.factory.ConnectionFactory;
import com.example.application.model.usuarioModel.UsuarioEnt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
   private Connection connection;

   public PedidoDao() {
      try {
         this.connection = ConnectionFactory.getConnection();
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }

   private List<PedidoEnt> Convert(String sql) {
      List<PedidoEnt> pedidos = new ArrayList<PedidoEnt>();
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
         ResultSet resultSet = preparedStatement.executeQuery();

         while(((ResultSet) resultSet).next()) {
            PedidoEnt pedido = new PedidoEnt();
            pedido.setId(resultSet.getLong("Id"));
            pedido.setIdProduto(resultSet.getLong("IdProduto"));
            pedido.setValor(resultSet.getDouble("Valor"));
            pedido.setQuantidade(resultSet.getInt("Quantidade"));
            pedidos.add(pedido);
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return pedidos;
   }

   public List<PedidoEnt> getPedido() {
      String sql = "SELECT * FROM PEDIDO";
      return Convert(sql);
   }
}
