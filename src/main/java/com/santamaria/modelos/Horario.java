package com.santamaria.modelos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Horario {
    public String dia;
    public String estado;
    public String horaInicio;
    public String horaFin;

    public Horario(String dia, String estado, String horaInicio, String horaFin) {
        this.dia = dia;
        this.estado = estado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Horario(String dia, String horaInicio, String horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public Horario(){
        
    }
    
    public static List<Horario> dividirTurnoEnHoras(String dia, LocalTime inicio, LocalTime fin) {
        List<Horario> horarios = new ArrayList<>();
        LocalTime horaActual = inicio;
        while (horaActual.isBefore(fin)) {
            LocalTime siguienteHora = horaActual.plusHours(1);
            if (siguienteHora.isAfter(fin)) {
                siguienteHora = fin;
            }
            horarios.add(new Horario(dia, horaActual.toString(), siguienteHora.toString()));
            horaActual = siguienteHora;
        }
        return horarios;
    }
    
    

    public String getDia() {
        return dia;
    }

    public String getEstado() {
        return estado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    @Override
    public String toString() {
        return dia + ": " + horaInicio + " - " + horaFin;
    }
}
