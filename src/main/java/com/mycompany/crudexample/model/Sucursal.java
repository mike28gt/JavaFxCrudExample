/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private final Connection conn = ConexionDb.getConexionDb().getConn();;

    public Sucursal() {
    }
    
    public Sucursal(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    public Sucursal(int codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
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
        stmt.executeUpdate("INSERT INTO sucursal(nombre, ciudad) VALUES ('"+sucursal.getNombre()+"', '"+sucursal.getCiudad()+"')");
    }
    
    public void eliminar(Sucursal sucursal) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM sucursal WHERE id_sucursal="+sucursal.getCodigo());
    }
    
    public void actualizar(Sucursal sucursal) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE sucursal set nombre = '"+sucursal.getNombre() +"', ciudad='"+sucursal.getCiudad()+"' WHERE id_sucursal="+sucursal.getCodigo());
    }
    
    public ObservableList<Sucursal> listar() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM sucursal");
        
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
