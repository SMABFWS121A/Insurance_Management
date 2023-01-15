package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class VehicleForm extends FormLayout {

    Binder<Vehicle> binder = new BeanValidationBinder<>(Vehicle.class);
    TextField marke = new TextField("Marke");
    TextField modell = new TextField("Modell");
    TextField baujahr = new TextField("Baujahr");

    Button save = new Button("Speichern");
    Button delete = new Button("Löschen");
    Button close = new Button("Abbrechen");
    private Vehicle vehicle;

    public VehicleForm() {
        addClassName("contact-form");
        binder.bindInstanceFields(this);

        add(marke, modell, baujahr, createButtonsLayout());
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        binder.readBean(vehicle);
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickListener(e -> validateAndSave());
        delete.addClickListener(e -> fireEvent(new DeleteEvent(this, vehicle)));
        close.addClickListener(e -> fireEvent(new CloseEvent(this)));

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(vehicle);
            fireEvent(new SaveEvent(this, vehicle));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    // Events
    public static abstract class VehicleFormEvent extends ComponentEvent<VehicleForm> {
        private Vehicle vehicle;

        protected VehicleFormEvent(VehicleForm source, Vehicle vehicle) {
            super(source, false);
            this.vehicle = vehicle;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    public static class SaveEvent extends VehicleForm.VehicleFormEvent {
        SaveEvent(VehicleForm source, Vehicle vehicle) {
            super(source, vehicle);
        }
    }

    public static class DeleteEvent extends VehicleForm.VehicleFormEvent {
        DeleteEvent(VehicleForm source, Vehicle vehicle) {
            super(source, vehicle);
        }

    }

    public static class CloseEvent extends VehicleForm.VehicleFormEvent {
        CloseEvent(VehicleForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
