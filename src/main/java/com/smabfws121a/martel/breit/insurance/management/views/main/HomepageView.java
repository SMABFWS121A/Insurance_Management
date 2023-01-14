package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Willkommen bei ABC Insurance!")
@Route(value = "",layout = Layout.class)
public class HomepageView extends VerticalLayout {

    public HomepageView() {

        Image homepageImg = new Image("/img/homepage_header.jpg", "ABC Insurance");
        homepageImg.setWidth("100%");

        add(homepageImg);
    }

}
