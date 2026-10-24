package com.santamaria.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String CONTROLADOR = "jdbc:mysql://";
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = ":3306/";
    private static final String DATABASE = "posta_santa_maria_db";
    private static final String URL = CONTROLADOR + SERVIDOR + PUERTO + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "TU_CONTRASEÑA"; // cambia esto por la contraseña de tu MySQL local

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
    
}
