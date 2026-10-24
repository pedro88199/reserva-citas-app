package com.santamaria.genetico;

import com.santamaria.modelos.Cita;
import com.santamaria.modelos.Horario;
import com.santamaria.modelos.Paciente;
import java.util.List;
import java.util.Map;

public class Individuo implements Comparable<Individuo> {
    public List<Cita> citas;
    public int aptitud;

    public Individuo(List<Cita> citas) {
        this.citas = citas;
        this.aptitud = 0; // Inicializamos la aptitud a 0, se calculará después
    }

    // Función para calcular la aptitud del individuo (fitness)
    public void calcularAptitud(List<Paciente> pacientes, Map<String, List<Horario>> disponibilidadDoctores) {
        int puntuacion = 0;
        for (Cita cita : citas) {
            Paciente paciente = Paciente.obtenerPacientePorNombre(cita.getNombrePaciente(), pacientes);
            if (paciente != null && paciente.getEspecialidadDeseada().equals(cita.getEspecialidadDoctor())) {
                List<Horario> horariosDisponibles = disponibilidadDoctores.get(cita.getNombreDoctor());
                if (horariosDisponibles != null && horariosDisponibles.contains(cita.getHorario())) {
                    puntuacion++;
                }
            }
        }
        this.aptitud = puntuacion;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public int getAptitud() {
        return aptitud;
    }

    @Override
    public int compareTo(Individuo otro) {
        return Integer.compare(otro.getAptitud(), this.getAptitud());
    }
}
