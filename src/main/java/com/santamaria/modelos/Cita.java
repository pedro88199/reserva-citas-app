package com.santamaria.modelos;

import java.time.LocalDate;

public class Cita {
    private int idPaciente;
    private int idDoctor;
    private LocalDate fecha;
    private String hora;
    private String nombrePaciente;
    private String nombreDoctor;
    private String especialidadDoctor;
    private Horario horario;
    private String estado;

    public Cita(String nombrePaciente, String nombreDoctor, String especialidadDoctor, LocalDate fecha, String hora, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombrePaciente = nombrePaciente;
        this.nombreDoctor = nombreDoctor;
        this.especialidadDoctor = especialidadDoctor;
        this.estado = estado;
    }

    public Cita(int idPaciente, String nombrePaciente, int idDoctor, String nombreDoctor, String especialidadDoctor, Horario horario) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.especialidadDoctor = especialidadDoctor;
        this.horario = horario;
        this.estado = "PENDIENTE";
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public String getEspecialidadDoctor() {
        return especialidadDoctor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public void setEspecialidadDoctor(String especialidadDoctor) {
        this.especialidadDoctor = especialidadDoctor;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public int getIdDoctor() { return idDoctor; }
    public void setIdDoctor(int idDoctor) { this.idDoctor = idDoctor; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    @Override
    public String toString(){
        return "Cita{" +
                "idPaciente=" + idPaciente +
                ", idDoctor=" + idDoctor +
                ", fecha=" + fecha +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", nombreDoctor='" + nombreDoctor + '\'' +
                ", especialidadDoctor='" + especialidadDoctor + '\'' +
                ", horario=" + horario +
                ", estado='" + estado + '\'' +
                '}';
    }
}
