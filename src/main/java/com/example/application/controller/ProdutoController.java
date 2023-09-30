package com.example.application.controller;

import com.example.application.model.produtoModel.ProdutoEnt;
import com.example.application.model.produtoModel.ProdutoDao;

public class ProdutoController {
    ProdutoDao proModel = new ProdutoDao();

    public void createProduto(ProdutoEnt prod) {
        proModel.InsertProduto(prod);
    }
}
