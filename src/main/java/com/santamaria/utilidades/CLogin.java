/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santamaria.utilidades;

import com.santamaria.vistas.Menu_Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */ 
public class CLogin {
    public boolean validaUsuario(JTextField usuario, JPasswordField contraseña) {
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            Connection conn = Database.obtenerConexion();
            String consulta = "SELECT * FROM login WHERE nombre = ? AND contrasena = ?";
            ps = conn.prepareStatement(consulta);
            String contra = String.valueOf(contraseña.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El Usuario es CORRECTO");
                Menu_Principal objetoMenu = new Menu_Principal();
                objetoMenu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario es INCORRECTO, vuelva a INTENTAR");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime la traza de la excepción en la consola
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        return false;

    }

}


