/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.controller;

import com.mycompany.crudexample.App;
import com.mycompany.crudexample.model.Sucursal;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author miguelcatalan
 */

public class SucursalAgregarEliminarController implements Initializable  {
    
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCiudad;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setData(Sucursal sucursal) {
        System.out.println(sucursal);
    }
    
    @FXML
    public void guardar() {
        Sucursal sucursal = new Sucursal(0,txtNombre.getText(), txtCiudad.getText());
        try {
            sucursal.guardar(sucursal);
            regresar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(sucursal);
    }
    
    @FXML
    public void regresar() throws IOException {
        App.setRoot("/com/mycompany/crudexample/view/sucursalPrincipal");
    }
}
