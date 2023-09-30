package com.example.application.model.pedidoModel;

public class PedidoEnt {
   private long Id;
   private long IdProduto;
   private double Valor;
   private int Quantidade;

   public long getId() {
      return Id;
   }

   public void setId(long id) {
      Id = id;
   }

   public long getIdProduto() {
      return IdProduto;
   }

   public void setIdProduto(long idProduto) {
      IdProduto = idProduto;
   }

   public double getValor() {
      return Valor;
   }

   public void setValor(double valor) {
      Valor = valor;
   }

   public int getQuantidade() {
      return Quantidade;
   }

   public void setQuantidade(int quantidade) {
      Quantidade = quantidade;
   }
}
