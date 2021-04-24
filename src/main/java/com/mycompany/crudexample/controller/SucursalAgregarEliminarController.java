/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.controller;

import com.google.common.eventbus.Subscribe;
import com.mycompany.crudexample.App;
import com.mycompany.crudexample.model.EventBusFactory;
import com.mycompany.crudexample.model.Sucursal;
import com.mycompany.crudexample.model.UpdateSucursalEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author miguelcatalan
 */

public class SucursalAgregarEliminarController implements Initializable  {
    
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCiudad;
    
    private boolean isEdicion = false;
    private Sucursal sucursalPivote;
    //EventBus eventBux = new EventBus();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EventBusFactory.getEventBus().register(this);
    }
    
    public void setData(Sucursal sucursal) {
        System.out.println(sucursal);
    }
    
    @FXML
    public void guardar() {
        Sucursal sucursal = new Sucursal(txtNombre.getText(), txtCiudad.getText());
        try {
            if (isEdicion) {
                sucursal.setCodigo(sucursalPivote.getCodigo());
                sucursal.actualizar(sucursal);
            }
            else {
                sucursal.guardar(sucursal);
            }
            regresar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(sucursal);
    }
    
    @Subscribe
    public void editar(UpdateSucursalEvent sucursalEvent) {
        System.out.println("Llama a editar en controller.");
        this.sucursalPivote = sucursalEvent.getSucursal();
        txtNombre.setText(this.sucursalPivote.getNombre());
        txtCiudad.setText(this.sucursalPivote.getCiudad());
        isEdicion = true;
    }
    
    @FXML
    public void regresar() throws IOException {
        App.setRoot("/com/mycompany/crudexample/view/sucursalPrincipal");
    }
}
