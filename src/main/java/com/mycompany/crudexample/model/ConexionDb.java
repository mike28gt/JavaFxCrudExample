/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.model;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelcatalan
 */
public class ConexionDb {
    
    private static ConexionDb conexionDb;
    private String url;
    private Connection conn;
    
    private ConexionDb() {
        this.url = "jdbc:oracle:thin:system/123$@localhost:1521:XE";
        
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ConexionDb getConexionDb() {
    
        if (conexionDb == null) {
            conexionDb = new ConexionDb();
        }
        
        return conexionDb;
    }
    
    public Connection getConn() {
        return conn;
    }
}
