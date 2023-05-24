package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ysai
 */
public abstract class ConexionBD {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static public String user = "root";
    static public String password = "";
    
    protected Connection conexion = null;
    
    public ConexionBD(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver: " + ex.getMessage());
        }
    }
    
    public void conectar(){
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        }

    }
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar: " + ex.getMessage());
        }
    }
}
