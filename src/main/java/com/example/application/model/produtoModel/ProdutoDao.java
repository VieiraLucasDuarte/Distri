package com.example.application.model.produtoModel;

import com.example.application.model.usuarioModel.UsuarioEnt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection connection;


    public ProdutoDao() {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:banco_distribuidora.db");
        } catch (SQLException e) {
            System.out.println("Caiu aq");
            e.printStackTrace();

        }
    }

    private void Insert(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public void InsertProduto(ProdutoEnt produto) {
        String insertSql = "Insert Into Produto (Nome, Estoque, Preco)values " +
                "('lucas" + produto.getNome() + "'" +
                "," + produto.getEstoque() + "" +
                ",'" + produto.getPreco() + "')";
        Insert(insertSql);
        System.out.println("Deubom");
    }


    private List<ProdutoEnt> Convert(String sql) {

        List<ProdutoEnt> produtos = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (((ResultSet) resultSet).next()) {
                ProdutoEnt consulta_produto = new ProdutoEnt();
                consulta_produto.setId(resultSet.getLong("id"));
                consulta_produto.setNome(resultSet.getString("nome"));
                consulta_produto.setEstoque(Integer.valueOf(resultSet.getString("estoque")));
                consulta_produto.setPreco(Double.parseDouble(resultSet.getString("preco")));
                produtos.add(consulta_produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuarios no banco de dados: " + e.getMessage());
        }
        return produtos;
    }

    public List<ProdutoEnt> getProduto() {
        String sql = "SELECT * FROM Produto";
        return Convert(sql);
    }
}
