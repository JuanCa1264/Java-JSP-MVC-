
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: Conexion
 * Autor: Juan Carlos Estrada Portillo
 * Versión: 1.0
 * CopyRight: ITCA-FEPADE
 * Fecha: 09/09/2019
 */
public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
 
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario2", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
    }
    
    public void desconectar() throws SQLException{
        if (con!=null) {
            if (con.isClosed()==false) {
                con.close();
            }
        }
    }
    
}
