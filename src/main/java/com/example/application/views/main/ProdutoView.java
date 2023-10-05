package com.example.application.views.main;

import com.example.application.controller.ProdutoController;
import com.example.application.model.produtoModel.ProdutoEnt;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;


@Route("Produto")
public class ProdutoView extends VerticalLayout {

    public ProdutoView() {
        ProdutoController proControl = new ProdutoController();

        Button BtnGravar = new Button("Gravar");
        TextField TextFieldNome = new TextField("Nome Produto:");
        TextField TextFieldEstoque = new TextField("Estoque:");
        TextField TextFieldPreco = new TextField("Preço:");

        ProdutoEnt produto = new ProdutoEnt();
        var layout = new VerticalLayout(
                TextFieldNome,TextFieldEstoque,TextFieldPreco,BtnGravar);

        BtnGravar.addClickListener(e ->{
            produto.setNome(TextFieldNome.getValue());
            produto.setEstoque(Integer.valueOf(TextFieldEstoque.getValue()));
            produto.setPreco(Double.parseDouble(TextFieldPreco.getValue()));
            TextFieldPreco.getValue();
            proControl.createProduto(produto);
            UI.getCurrent().navigate(LoginView.class);
        });

        layout.setWidthFull();
        layout.setJustifyContentMode(JustifyContentMode.CENTER);
        layout.setAlignItems(Alignment.CENTER);
        add(layout);
    }


}
