/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santamaria.utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CRegistro {
    public void validaRegistro(JTextField usuario, JPasswordField contraseña, JPasswordField CContraseña, JTextField Nombre, JTextField Correo) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = Database.obtenerConexion();
        try {
            String contra = String.valueOf(contraseña.getPassword());
            String confirmaContra = String.valueOf(CContraseña.getPassword());
            if (!contra.equals(confirmaContra)) {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String consulta = "INSERT INTO login (nombre, contrasena) VALUES (?, ?);";
            ps = conn.prepareStatement(consulta);
            ps.setString(1, Nombre.getText());
            ps.setString(2, contra);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
}


