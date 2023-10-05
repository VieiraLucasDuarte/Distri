package com.example.application.model.produtoModel;

import java.sql.*;

public class ProdutoDao {
    private Connection connection;


    public ProdutoDao() {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:banco_distribuidora.db");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void Insert(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertProduto(ProdutoEnt produto) {
        String insertSql = "Insert Into Produto (Nome, Estoque, Preco)values " +
                "('lucas" + produto.getNome() + "'" +
                "," + produto.getEstoque() + "" +
                ",'" + produto.getPreco() + "')";
        Insert(insertSql);
    }
}
