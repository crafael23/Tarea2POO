/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2poo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author vascl
 */
public class Conexion {
    
    private Connection cnx;
    
    public Conexion(){
        try {
            
            String url = "jdbc:mysql://poo-prueba01.mysql.database.azure.com:3306/sistematecnico?useSSL=false";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            cnx= DriverManager.getConnection(url, "Nimbus_01", "POO_prueba01");
            
            
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public Connection getCnx() {
        return cnx;
    }
    public Statement createStatement() {
        Statement stm = null;

        try {
            stm = cnx.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stm;
    }
    
    public PreparedStatement createPreparedStatement(String statement) {
        PreparedStatement pstm = null;
        try {
            pstm = cnx.prepareStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstm;
    }
    
}
