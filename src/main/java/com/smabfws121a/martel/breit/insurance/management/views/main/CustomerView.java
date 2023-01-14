package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.classes.Kunde;
import com.smabfws121a.martel.breit.insurance.management.service.SqlService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@PageTitle("Kunden | ABC Insurance")
@Route(value = "Kunden", layout = Layout.class)
public class CustomerView extends VerticalLayout {
    Grid<Kunde> grid = new Grid<>(Kunde.class);
    TextField filterText = new TextField();
    CustomerForm form;
    SqlService service;

    public CustomerView(SqlService service) {
        addClassName("customer-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
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
        form = new CustomerForm();
        form.setWidth("25em");
    }

    private void configureGrid() {
        grid.addClassNames("customer-grid");
        grid.setSizeFull();
        grid.setColumns("kdnr", "vorname", "nachname", "strasse", "hausnr", "plz", "ort");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Nach Namen filtern...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addCustomerButton = new Button("Kunden hinzufügen");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addCustomerButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(service.findAllCustomers(filterText.getValue()));
    }
}
