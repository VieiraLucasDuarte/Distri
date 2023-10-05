package com.example.application.views.main;

import com.example.application.controller.UsuarioController;
import com.example.application.model.usuarioModel.UsuarioEnt;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("CadastroUsuario")
public class CadastroUsuarioView extends VerticalLayout {

    public CadastroUsuarioView() {

        Text title = new Text("Cadastro de Usuário");
        TextField user = new TextField("Usuário");
        PasswordField password = new PasswordField ("Senha");
        Button btn = new Button("Gravar");
        Button cancelBtn = new Button("Cancelar");

        btn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelBtn.addThemeVariants(ButtonVariant.LUMO_ERROR);
        password.setRevealButtonVisible(true);

        var layout = new VerticalLayout(
                title, user, password, btn, cancelBtn
        );

        btn.addClickListener(x -> {
            createUsuario(user.getValue(), password.getValue());
        });

        cancelBtn.addClickListener(x -> {
            UI.getCurrent().navigate(LoginView.class);
        });

        layout.setWidthFull();
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        add(layout);
    }

    private void createUsuario(String usuario, String senha) {
        UsuarioController con = new UsuarioController();

        con.create(usuario, senha);
        UI.getCurrent().navigate(LoginView.class);
    }
}
