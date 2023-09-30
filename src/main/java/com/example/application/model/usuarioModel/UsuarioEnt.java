package com.example.application.model.usuarioModel;

public class UsuarioEnt {
   private long Id;
   private String Nome;
   private String Senha;

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

   public String getSenha() {
      return Senha;
   }

   public void setSenha(String senha) {
      Senha = senha;
   }
}
