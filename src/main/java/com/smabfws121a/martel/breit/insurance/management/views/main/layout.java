package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;

// layout extends from AppLayout (Vaadin)
public class layout extends AppLayout {

    // create general static things to show on every view
    public layout() {

        // ToDo: outsource into own function
        // shows the company logo in the header
        Image headerLogo = new Image("/img/abc_insurance.png", "ABC Insurance");
        headerLogo.setHeight("60px");


        // create website head
        HorizontalLayout head = new HorizontalLayout(headerLogo);

        // set header alignment to center (vertically), html-class and 100% width
        head.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        head.addClassNames("header");
        head.setWidth("100%");

        //add head to navbar
        addToNavbar(head);

    }

}
