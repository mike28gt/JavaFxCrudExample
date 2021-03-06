/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.controller;

import com.google.common.eventbus.EventBus;
import com.mycompany.crudexample.App;
import com.mycompany.crudexample.model.EventBusFactory;
import com.mycompany.crudexample.model.Sucursal;
import com.mycompany.crudexample.model.UpdateSucursalEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author miguelcatalan
 */
public class SucursalPrincipalController implements Initializable {
    
    @FXML
    private TableView<Sucursal> tableSucursal;

    @FXML
    private TableColumn<Sucursal, Integer> codigo;

    @FXML
    private TableColumn<Sucursal, String> nombre;

    @FXML
    private TableColumn<Sucursal, String> ciudad;
    
    EventBus eventBus = EventBusFactory.getEventBus();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        codigo.setCellValueFactory(new PropertyValueFactory<Sucursal, Integer>("codigo"));
        nombre.setCellValueFactory(new PropertyValueFactory<Sucursal, String>("nombre"));
        ciudad.setCellValueFactory(new PropertyValueFactory<Sucursal, String>("ciudad"));
        
        tableSucursal.setRowFactory(tv -> {
            TableRow<Sucursal> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty())) {
                    Sucursal sucursal = row.getItem();
                    System.out.println(sucursal);
                    
                    try {
                        editarSucursal(sucursal);
                    }
                    catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            });
            return row;
        });
        
        try {
            tableSucursal.setItems(new Sucursal().listar());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @FXML
    public void eliminarSucursal() {
        Sucursal sucursal = tableSucursal.getSelectionModel().getSelectedItem();
        
        if (sucursal != null) {
            System.out.println(sucursal);
            try {
                sucursal.eliminar(sucursal);
                tableSucursal.setItems(new Sucursal().listar());
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            //Put code to remove item here
        }
    }
    
    @FXML
    public void nuevaSucursal() throws IOException {
        App.setRoot("/com/mycompany/crudexample/view/sucursalAgregarEliminar");
    }
    
    private void editarSucursal(Sucursal sucursal) throws IOException {
        App.setRoot("/com/mycompany/crudexample/view/sucursalAgregarEliminar");
        UpdateSucursalEvent sucursalEvent = new UpdateSucursalEvent(sucursal);
        eventBus.post(sucursalEvent);
    }
    
    
}
