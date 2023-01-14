package com.smabfws121a.martel.breit.insurance.management.views.main;

import com.smabfws121a.martel.breit.insurance.management.data.classes.Customer;
import com.smabfws121a.martel.breit.insurance.management.data.classes.Vehicle;
import com.smabfws121a.martel.breit.insurance.management.data.service.SqlService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.stream.Stream;

@PageTitle("Fahrzeuge | ABC Insurance")
@Route(value = "vehicles", layout = Layout.class)
public class VehicleView extends VerticalLayout {
    Grid<Vehicle> grid = new Grid<>(Vehicle.class);
    TextField filterText = new TextField();
    SqlService service;

    public VehicleView(SqlService service) {
        this.service = service;
        addClassName("vehicle-view");
        setSizeFull();
        configureGrid();

        add(getToolbar(), getContent());
        updateList();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setFlexGrow(2, grid);
        content.addClassName("content");
        content.setSizeFull();

        return content;
    }

    private void configureGrid() {
        grid.addClassNames("vehicle-grid");
        grid.setSizeFull();
        grid.setColumns("marke", "modell");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Nach Marke oder Modell filtern...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(service.findAllVehicles(filterText.getValue()));
    }
}
