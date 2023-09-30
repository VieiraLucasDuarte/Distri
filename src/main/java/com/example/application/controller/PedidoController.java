package com.example.application.controller;

import com.example.application.model.pedidoModel.PedidoDao;
import com.example.application.model.pedidoModel.PedidoEnt;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
   private PedidoDao pedidoDao = new PedidoDao();

   public List<PedidoEnt> listPedido() {
      List<PedidoEnt> pedidos = new ArrayList<>();
      return pedidoDao.getPedido();
   }
}
