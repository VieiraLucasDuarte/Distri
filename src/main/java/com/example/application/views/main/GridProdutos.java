package com.example.application.views.main;

import com.example.application.model.produtoModel.ProdutoDao;
import com.example.application.model.produtoModel.ProdutoEnt;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Grid_Produtos")
public class GridProdutos extends VerticalLayout{

    Grid<ProdutoEnt> grid = new Grid<>(ProdutoEnt.class);

    public GridProdutos() {

        Button BtnVoltar = new Button("Voltar");
        var layout = new VerticalLayout(BtnVoltar);

        addClassName("list-view");
        setSizeFull();

        add(grid);
        updateList();

        BtnVoltar.addClickListener(x -> {
            UI.getCurrent().navigate(ProdutoView.class);
        });

        layout.setWidthFull();
        layout.setJustifyContentMode(JustifyContentMode.CENTER);
        layout.setAlignItems(Alignment.CENTER);
        add(layout);
    }

    private void updateList(){
        ProdutoDao produtoDao  = new  ProdutoDao();
        grid.setItems(produtoDao.getProduto());
    }

}
