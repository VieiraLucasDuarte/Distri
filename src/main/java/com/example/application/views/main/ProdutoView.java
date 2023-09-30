package com.example.application.views.main;

import com.example.application.controller.ProdutoController;
import com.example.application.model.produtoModel.ProdutoEnt;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("produto")
public class ProdutoView extends Composite<VerticalLayout> {

    ProdutoController proControl = new ProdutoController();
    private Button btnEnviar;
    private TextField envio;

    public ProdutoView() {
        ///formualrio de cadastrar um produto
        envio = new TextField("Digite o nome ");
        btnEnviar = new Button("Enviar");
        btnEnviar.addClickListener(event -> {
//            createProduto();
        });

        ///cadastra um produto
        //prenhce um entProduto e envia para o metodo CreateProduto
    }

    public void createProduto(ProdutoEnt produto) {
        proControl.createProduto(produto);
    }

}
