package com.santamaria.modelos;

import com.santamaria.utilidades.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Paciente {

    public int idPaciente;
    public String nombre;
    public String apellido;
    public String especialidadDeseada;
    public String dni;
    public String telefono;
    public String direccion;
    public String fechaNacimiento;
    public String sexo;

    public Paciente(String nombre, String especialidadDeseada) {
        this.nombre = nombre;
        this.especialidadDeseada = especialidadDeseada;
    }

    public Paciente(String nombre, String apellido, String especialidadDeseada){
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidadDeseada = especialidadDeseada;
    }

    public static List<Paciente> obtenerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (Connection conexion = Database.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT p.id_paciente, p.nombre , p.especialidadDeseada " +
                             "FROM paciente p " +
                             "LEFT JOIN cita c ON p.id_paciente = c.paciente_id " +
                             "WHERE c.id_cita IS NULL")) {

            while (rs.next()) {
                int idPaciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String especialidadDeseada = rs.getString("especialidadDeseada");
                Paciente paciente = new Paciente(nombre, especialidadDeseada);
                paciente.setIdPaciente(idPaciente);
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public static Paciente obtenerPacientePorNombre(String nombrePaciente, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.nombre.equals(nombrePaciente)) {
                return paciente;
            }
        }
        return null;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidadDeseada() {
        return especialidadDeseada;
    }

    public void setEspecialidadDeseada(String especialidadDeseada) {
        this.especialidadDeseada = especialidadDeseada;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
