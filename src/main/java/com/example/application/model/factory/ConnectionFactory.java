package com.example.application.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
   private static final String URL = "jdbc:sqlite:banco_distribuidora.db";

   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL);
   }
}
