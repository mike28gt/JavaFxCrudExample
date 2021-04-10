/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.model;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author miguelcatalan
 */
public class Sucursal {
    private int codigo;
    private String nombre;
    private String ciudad;
    private Connection conn;

    public Sucursal() {
        String url = "jdbc:oracle:oci:PROGRAMACION1/123$@localhost:1521:umg";
        
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Sucursal(int codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        
        String url = "jdbc:oracle:oci:PROGRAMACION1/123$@localhost:1521:umg";
        
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void guardar(Sucursal sucursal) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO programacion1.sucursal(nombre, ciudad) VALUES ('"+sucursal.getNombre()+"', '"+sucursal.getCiudad()+"')");
    }
    
    public void eliminar(Sucursal sucursal) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM programacion1.sucursal WHERE id_sucursal="+sucursal.getCodigo());
    }
    
    public void actualizar(Sucursal sucursal) {
        
    }
    
    public ObservableList<Sucursal> listar() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM programacion1.sucursal");
        
        ObservableList<Sucursal> data = FXCollections.observableArrayList();
        
        while(rs.next()){
            //ObservableList<Sucursal> row = FXCollections.observableArrayList();
            data.add(new Sucursal(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        
        return data;
    }
    
    @Override
    public String toString() {
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }
}
