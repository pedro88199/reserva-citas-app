package com.santamaria.modelos;

import com.santamaria.utilidades.Database;
import static java.lang.Math.random;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {

    public int idDoctor;
    public int espaciosDisponibles;
    public String nombre;
    public String especialidad;
    public String id;

    public Doctor(int idDoctor, String nombre, String especialidad) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Doctor(String nombre, String especialidad, String id, int espaciosDisponibles) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id = id;
        this.espaciosDisponibles = espaciosDisponibles;
    }

    public static List<Doctor> obtenerDoctores() {
        List<Doctor> doctores = new ArrayList<>();
        try (Connection conexion = Database.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id_doctor, nombre, especialidad " +
                             "FROM doctor")) {

            while (rs.next()) {
                int id_doctor = rs.getInt("id_doctor");
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                Doctor doctor = new Doctor(id_doctor, nombre, especialidad);
                doctores.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctores;
    }

    public static Map<String, List<Horario>> obtenerDisponibilidadDoctores() {
        Map<String, List<Horario>> disponibilidad = new HashMap<>();
        try (Connection conexion = Database.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT d.nombre, h.dia, h.estado, h.hora_inicio, h.hora_fin " +
                             "FROM doctor d " +
                             "JOIN horario h ON d.id_horario = h.id_horario " +
                             "WHERE h.estado = 'Disponible'")) {

            while (rs.next()) {
                String nombreDoctor = rs.getString("nombre");
                String dia = rs.getString("dia");
                LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
                LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();

                List<Horario> horariosPorHoras = new ArrayList<>();
                for (LocalTime hora = horaInicio; hora.isBefore(horaFin); hora = hora.plusHours(1)) {
                    horariosPorHoras.add(new Horario(dia, "Disponible", hora.toString(), hora.plusHours(1).toString()));
                }

                disponibilidad
                        .computeIfAbsent(nombreDoctor, k -> new ArrayList<>())
                        .addAll(horariosPorHoras);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disponibilidad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
