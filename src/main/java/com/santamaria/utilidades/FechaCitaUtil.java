package com.santamaria.utilidades;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class FechaCitaUtil {

    public static LocalDate calcularProximaFecha(DayOfWeek diaSemana) {
        LocalDate hoy = LocalDate.now();
        LocalDate proximaFecha = hoy.with(diaSemana);
        if (hoy.compareTo(proximaFecha) >= 0) {
            proximaFecha = proximaFecha.plusWeeks(1);
        }
        return proximaFecha;
    }

    public static DayOfWeek convertirDiaSemana(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return DayOfWeek.MONDAY;
            case "martes":
                return DayOfWeek.TUESDAY;
            case "miercoles":
                return DayOfWeek.WEDNESDAY;
            case "jueves":
                return DayOfWeek.THURSDAY;
            case "viernes":
                return DayOfWeek.FRIDAY;
            case "sabado":
                return DayOfWeek.SATURDAY;
            case "domingo":
                return DayOfWeek.SUNDAY;
            default:
                throw new IllegalArgumentException("Día de la semana inválido: " + dia);
        }
    }
}