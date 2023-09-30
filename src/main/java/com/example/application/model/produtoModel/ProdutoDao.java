package com.example.application.model.produtoModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao {
    private Connection connection;

    public ProdutoDao() {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:distribuidora.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Insert(String sql) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertProduto(ProdutoEnt produto) {
        String insertSql = "INSERT INTO Produto (Nome, Estoque, Preco) values ('" + produto.getNome() + "'," + produto.getEstoque() + "," + produto.getPreco() + ")";
    }
}
