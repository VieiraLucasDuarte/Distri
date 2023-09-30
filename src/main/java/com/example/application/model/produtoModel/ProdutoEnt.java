package com.example.application.model.produtoModel;

public class ProdutoEnt {
   private long Id;
   private String Nome;
   private long Estoque;
   private double Preco;

   public long getId() {
      return Id;
   }

   public void setId(long id) {
      Id = id;
   }

   public String getNome() {
      return Nome;
   }

   public void setNome(String nome) {
      Nome = nome;
   }

   public long getEstoque() {
      return Estoque;
   }

   public void setEstoque(long estoque) {
      Estoque = estoque;
   }

   public double getPreco() {
      return Preco;
   }

   public void setPreco(double preco) {
      Preco = preco;
   }
}
