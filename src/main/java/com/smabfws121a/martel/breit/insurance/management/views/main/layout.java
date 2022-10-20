package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

// layout extends from AppLayout (Vaadin)
public class layout extends AppLayout {

    // create general static things to show on every view
    public layout() {

        createHeader();
        createDrawer();

    }

    // adds a header to every page
    private void createHeader() {

        // shows the company logo in the header
        //Image headerLogo = new Image("/img/abc_insurance.png", "ABC Insurance");
        //headerLogo.setHeight("60px");
        H1 headerLogoText = new H1("ABC Insurance");
        headerLogoText.addClassNames("text-l", "m-m");

        // create website head
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), headerLogoText);

        // set header alignment and style
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        header.setWidth("100%");

        //add head to navbar
        addToNavbar(header);

    }

    // adds a drawer to every page
    private void createDrawer() {

        //homepage
        RouterLink homepageLink = new RouterLink("Startseite", homepageView.class);
        homepageLink.setHighlightCondition(HighlightConditions.sameLocation());

        //login
        RouterLink loginLink = new RouterLink("Login", loginView.class);
        homepageLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(homepageLink, loginLink));
    }

}
