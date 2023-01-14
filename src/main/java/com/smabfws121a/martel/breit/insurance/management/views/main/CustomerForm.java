package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class CustomerForm extends FormLayout {

    Binder<Customer> binder = new BeanValidationBinder<>(Customer.class);
    TextField firstName = new TextField("Vorname");
    TextField lastName = new TextField("Nachname");
    TextField strasse = new TextField("Straße");
    TextField hausnr = new TextField("Hausnummer");
    TextField plz = new TextField("PLZ");
    TextField ort = new TextField("Ort");
    ComboBox<Vehicle> vehicle = new ComboBox<>("Vehicle");

    Button save = new Button("Speichern");
    Button delete = new Button("Löschen");
    Button close = new Button("Abbrechen");
    private Customer customer;

    public CustomerForm(List<Vehicle> vehicles) {
        addClassName("contact-form");
        binder.bindInstanceFields(this);

        vehicle.setItems(vehicles);
        vehicle.setItemLabelGenerator(Vehicle::getBezeichnung);
        add(firstName, lastName, strasse, hausnr, plz, ort, createButtonsLayout());
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        binder.readBean(customer);
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(e -> validateAndSave());
        delete.addClickListener(e -> fireEvent(new DeleteEvent(this, customer)));
        close.addClickListener(e -> fireEvent(new CloseEvent(this)));

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(customer);
            fireEvent(new SaveEvent(this, customer));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    // Events
    public static abstract class ContactFormEvent extends ComponentEvent<CustomerForm> {
        private Customer customer;

        protected ContactFormEvent(CustomerForm source, Customer customer) {
            super(source, false);
            this.customer = customer;
        }

        public Customer getCustomer() {
            return customer;
        }
    }

    public static class SaveEvent extends ContactFormEvent {
        SaveEvent(CustomerForm source, Customer customer) {
            super(source, customer);
        }
    }

    public static class DeleteEvent extends ContactFormEvent {
        DeleteEvent(CustomerForm source, Customer customer) {
            super(source, customer);
        }

    }

    public static class CloseEvent extends ContactFormEvent {
        CloseEvent(CustomerForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
