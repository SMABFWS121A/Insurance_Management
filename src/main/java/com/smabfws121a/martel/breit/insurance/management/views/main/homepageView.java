package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.connectDatabase;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.sql.SQLException;

@PageTitle("Willkommen bei ABC Insurance!")
@Route(value = "",layout = layout.class)
public class homepageView extends VerticalLayout {

    public homepageView() {
        //Button buttonLogin = new Button("Login");
        //buttonLogin.addClickListener(e -> UI.getCurrent().navigate("login"));

        Button connectDB = new Button("DEBUG: Connect to Database");
        connectDB.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        connectDB.setWidth("100%");

        connectDB.addClickListener(event -> {
            try {
                connectDatabase.setConnectDatabase();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        Image homepageImg = new Image("/img/homepage_header.jpg", "ABC Insurance");
        homepageImg.setWidth("100%");

        add(connectDB, homepageImg);
    }

}
