package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

//@Route("login-overlay-internationalization")
@PageTitle("Login | ABC Insurance")
@Route(value = "login",layout = Layout.class)
public class LoginView extends Div {

    public LoginView() {

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setTitle("ABC Insurance");
        loginOverlay.setDescription("Ihr Versicherer!");
        add(loginOverlay);
        loginOverlay.setOpened(true);
        loginOverlay.getElement().setAttribute("no-autofocus", "");
    }


}
