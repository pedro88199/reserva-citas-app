package com.santamaria.genetico;

import com.santamaria.modelos.Cita;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import com.santamaria.utilidades.FechaCitaUtil;

public class Algoritmo {

    static final int GENERACIONES = 25;

    public List<Cita> ejecutar() {

        Poblacion poblacion = new Poblacion();

        // Evolución de la población
        for (int generacion = 0; generacion < GENERACIONES; generacion++) {
            poblacion.evolucionar();
            // Imprimir el mejor individuo de cada generación
            System.out.println("Generación " + generacion + " mejor aptitud: " + poblacion.getMejorIndividuo().aptitud);
        }

        // Obtener citas del mejor individuo y calcular fechas
        List<Cita> citas = poblacion.getMejorIndividuo().getCitas();
        for (Cita cita : citas) {
            DayOfWeek diaSemana = FechaCitaUtil.convertirDiaSemana(cita.getHorario().getDia());
            LocalDate fechaCita = FechaCitaUtil.calcularProximaFecha(diaSemana);
            cita.setFecha(fechaCita);
        }

        return citas;
    }
}
