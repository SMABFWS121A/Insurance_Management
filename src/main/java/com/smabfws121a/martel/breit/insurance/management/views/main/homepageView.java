package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Willkommen bei ABC Insurance!")
@Route(value = "",layout = layout.class)
public class homepageView extends VerticalLayout {

    public homepageView() {
        Button buttonLogin = new Button("Login");
        buttonLogin.addClickListener(e -> UI.getCurrent().navigate("login"));

        add(buttonLogin);
    }

}
