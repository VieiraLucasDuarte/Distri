package com.example.application.views.main;

import com.example.application.controller.UsuarioController;
import com.example.application.model.usuarioModel.UsuarioEnt;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Navigation;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.atmosphere.config.service.Message;


@Route("")
public class LoginView extends VerticalLayout {

   public LoginView() {

      Text title = new Text("Faça seu Login!");
      Button button = new Button("Gravar");
      TextField user = new TextField("Usuário");
      PasswordField password = new PasswordField ("Senha");
      Button forgotBtn = new Button("Criar cadastro?");

      button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
      forgotBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

      password.setRevealButtonVisible(true);

      var layout = new VerticalLayout(
              title,
              user,
              password,
              button,
              forgotBtn
      );

      button.addClickListener(x -> {
         var result = verifyUsuario(user.getValue(), password.getValue());
         if (result) {
            UI.getCurrent().navigate(ProdutoView.class);
         }
      });

      forgotBtn.addClickListener(x -> {
         UI.getCurrent().navigate(CadastroUsuarioView.class);
      });

      layout.setWidthFull();
      layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
      layout.setAlignItems(FlexComponent.Alignment.CENTER);
      add(layout);
   }

    private boolean verifyUsuario(String nome, String senha) {
       UsuarioController con = new UsuarioController();
       UsuarioEnt usu = con.listUsuario(nome).get(0);

       if(usu.getSenha().equals(senha)){
          //Notification notification = Notification
                  //.show("Financial report generated");
          return true;
       }
       return false;
    }

}
