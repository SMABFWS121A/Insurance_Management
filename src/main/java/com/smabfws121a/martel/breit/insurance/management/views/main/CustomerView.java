package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Kunde;
import com.smabfws121a.martel.breit.insurance.management.data.service.SqlService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collection;

@PageTitle("Kunden | ABC Insurance")
@Route(value = "Kunden", layout = Layout.class)
public class CustomerView extends VerticalLayout {
    Grid<Kunde> grid = new Grid<>(Kunde.class);
    TextField filterText = new TextField();
    CustomerForm form;
    SqlService service;

    public CustomerView(SqlService service) {
        this.service = service;
        addClassName("customer-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setCustomer(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private void configureForm() {
        form = new CustomerForm(service.findAllVehicles());
        form.setWidth("25em");

        form.addListener(CustomerForm.SaveEvent.class, this::saveCustomer);
        form.addListener(CustomerForm.DeleteEvent.class, this::deleteCustomer);
        form.addListener(CustomerForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveCustomer(CustomerForm.SaveEvent event) {
        service.saveCustomer(event.getCustomer());
        updateList();
        closeEditor();
    }

    private void deleteCustomer(CustomerForm.DeleteEvent event) {
        service.deleteCustomer(event.getCustomer());
        updateList();
        closeEditor();
    }

    private void configureGrid() {
        grid.addClassNames("customer-grid");
        grid.setSizeFull();
        grid.setColumns("vorname", "nachname", "strasse", "hausnr", "plz", "ort");
        grid.addColumn(customer -> customer.getVehicleName()).setHeader("Fahrzeug");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(e -> editCustomer(e.getValue()));
    }

    private void editCustomer(Kunde customer) {
        if (customer == null) {
            closeEditor();
        } else {
            form.setCustomer(customer);
            form.setVisible(true);
            form.addClassName("editing");
        }
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Nach Namen filtern...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addCustomerButton = new Button("Kunden hinzufügen");
        addCustomerButton.addClickListener(e -> addCustomer());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addCustomerButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addCustomer() {
        grid.asSingleSelect().clear();
        editCustomer(new Kunde());
    }

    private void updateList() {
        grid.setItems(service.findAllCustomers(filterText.getValue()));
    }
}
