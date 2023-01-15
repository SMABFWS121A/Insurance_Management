package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.smabfws121a.martel.breit.insurance.management.data.service.SqlService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Fahrzeuge | ABC Insurance")
@Route(value = "vehicles", layout = Layout.class)
public class VehicleView extends VerticalLayout {
    Grid<Vehicle> grid = new Grid<>(Vehicle.class);
    TextField filterText = new TextField();
    VehicleForm form;
    SqlService service;

    public VehicleView(SqlService service) {
        this.service = service;
        addClassName("vehicle-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private void closeEditor() {
        form.setVehicle(null);
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
        form = new VehicleForm();
        form.setWidth("30em");

        form.addListener(VehicleForm.SaveEvent.class, this::saveVehicle);
        form.addListener(VehicleForm.DeleteEvent.class, this::deleteVehicle);
        form.addListener(VehicleForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveVehicle(VehicleForm.SaveEvent event) {
        service.saveVehicle(event.getVehicle());
        updateList();
        closeEditor();
    }

    private void deleteVehicle(VehicleForm.DeleteEvent event) {
        service.deleteVehicle(event.getVehicle());
        updateList();
        closeEditor();
    }

    private void configureGrid() {
        grid.addClassNames("vehicle-grid");
        grid.setSizeFull();
        grid.setColumns("marke", "modell", "baujahr");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(e -> editVehicle(e.getValue()));
    }

    private void editVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            closeEditor();
        } else {
            form.setVehicle(vehicle);
            form.setVisible(true);
            form.addClassName("editing");
        }
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Nach Fahrzeug suchen...");
        filterText.setWidth("13em");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addVehicleButton = new Button("Fahrzeug hinzufügen");
        addVehicleButton.addClickListener(e -> addVehicle());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addVehicleButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addVehicle() {
        grid.asSingleSelect().clear();
        editVehicle(new Vehicle());
    }

    private void updateList() {
        grid.setItems(service.findAllVehicles(filterText.getValue()));
    }
}
