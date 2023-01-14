package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CustomerForm extends FormLayout {

    TextField kdnr = new TextField("Kundennummer");
    TextField firstName = new TextField("Vorname");
    TextField lastName = new TextField("Nachname");
    TextField strasse = new TextField("Straße");
    TextField hausnr = new TextField("Hausnummer");
    TextField plz = new TextField("PLZ");
    TextField ort = new TextField("Ort");

    Button save = new Button("Speichern");
    Button delete = new Button("Löschen");
    Button close = new Button("Abbrechen");

    public CustomerForm() {
        addClassName("contact-form");

        add(kdnr,
                firstName,
                lastName,
                strasse,
                hausnr,
                plz,
                ort,
                createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }
}
