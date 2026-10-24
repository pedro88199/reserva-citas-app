package com.santamaria.genetico;

import com.santamaria.modelos.Cita;
import com.santamaria.modelos.Doctor;
import com.santamaria.modelos.Horario;
import com.santamaria.modelos.Paciente;

import java.util.*;

public class Poblacion {
    static final int TAMANO_POBLACION = 50;
    static final double TASA_MUTACION = 0.01;
    static final Random random = new Random();

    List<Paciente> pacientes;
    List<Doctor> doctores;
    Map<String, List<Horario>> disponibilidadDoctores;

    List<Individuo> individuos;

    public Poblacion() {
        this.pacientes = Paciente.obtenerPacientes();
        this.doctores = Doctor.obtenerDoctores();
        this.disponibilidadDoctores = Doctor.obtenerDisponibilidadDoctores();
        this.individuos = new ArrayList<>();
        inicializarPoblacion();
    }

    // Inicialización de la población
    public void inicializarPoblacion() {
        for (int i = 0; i < TAMANO_POBLACION; i++) {
            individuos.add(generarIndividuoAleatorio());
        }
    }

    // Generar un individuo aleatorio
    public Individuo generarIndividuoAleatorio() {
        List<Cita> citas = new ArrayList<>();
        Map<String, Set<String>> horariosOcupados = new HashMap<>();
        for (Paciente paciente : pacientes) {
            Doctor doctor = obtenerDoctorAdecuado(paciente.getEspecialidadDeseada());
            Horario horario = obtenerHorarioAleatorio(doctor, horariosOcupados);
            if (horario != null) {
                String horarioClave = doctor.getNombre() + horario.getDia() + horario.getHoraInicio();
                horariosOcupados.computeIfAbsent(horarioClave, k -> new HashSet<>()).add(horario.getHoraInicio());
                citas.add(new Cita(paciente.getIdPaciente(), paciente.getNombre(), doctor.getIdDoctor(), doctor.getNombre(), paciente.getEspecialidadDeseada(), horario));
            }
        }
        Individuo nuevoIndividuo = new Individuo(citas);
        nuevoIndividuo.calcularAptitud(pacientes, disponibilidadDoctores);
        return nuevoIndividuo;
    }

    private Doctor obtenerDoctorAdecuado(String especialidadDeseada) {
        List<Doctor> doctoresEspecialidad = new ArrayList<>();
        for (Doctor doctor : doctores) {
            if (doctor.getEspecialidad().equals(especialidadDeseada)) {
                doctoresEspecialidad.add(doctor);
            }
        }
        return doctoresEspecialidad.get(random.nextInt(doctoresEspecialidad.size()));
    }

    // Obtener un horario aleatorio de la disponibilidad de un doctor
    private Horario obtenerHorarioAleatorio(Doctor doctor, Map<String, Set<String>> horariosOcupados) {
        List<Horario> horarios = disponibilidadDoctores.get(doctor.getNombre());
        if (horarios == null || horarios.isEmpty()) {
            return null;
        }

        List<Horario> horariosDisponibles = new ArrayList<>();
        for (Horario horario : horarios) {
            String horarioClave = doctor.getNombre() + horario.getDia() + horario.getHoraInicio();
            Set<String> horasOcupadas = horariosOcupados.getOrDefault(horarioClave, new HashSet<>());
            if (!horasOcupadas.contains(horario.getHoraInicio())) {
                horariosDisponibles.add(horario);
            }
        }

        if (horariosDisponibles.isEmpty()) {
            return null;
        }

        return horariosDisponibles.get(random.nextInt(horariosDisponibles.size()));
    }
    
    public void mutar(Individuo individuo) {
        for (Cita cita : individuo.getCitas()) {
            if (random.nextDouble() < TASA_MUTACION) {
                Paciente paciente = Paciente.obtenerPacientePorNombre(cita.getNombrePaciente(), pacientes);
                Doctor doctor = obtenerDoctorAdecuado(paciente.getEspecialidadDeseada());
                Map<String, Set<String>> horariosOcupados = new HashMap<>();
                Horario horario = obtenerHorarioAleatorio(doctor, horariosOcupados);
                cita.setNombreDoctor(doctor.getNombre());
                cita.setEspecialidadDoctor(doctor.getEspecialidad());
                cita.setHorario(horario);
            }
        }
        individuo.calcularAptitud(pacientes, disponibilidadDoctores);
    }

    // Cruzar dos individuos y generar un hijo
    public Individuo cruzar(Individuo padre1, Individuo padre2) {
        List<Cita> citasHijo = new ArrayList<>();
        for (int i = 0; i < padre1.getCitas().size(); i++) {
            Cita cita = random.nextBoolean() ? padre1.getCitas().get(i) : padre2.getCitas().get(i);
            citasHijo.add(cita);
        }
        Individuo hijo = new Individuo(citasHijo);
        hijo.calcularAptitud(pacientes, disponibilidadDoctores);
        return hijo;
    }

    // Evolucionar la población
    public void evolucionar() {
        Collections.sort(individuos);

        List<Individuo> nuevaPoblacion = new ArrayList<>();
        // Mantener los mejores individuos
        for (int i = 0; i < TAMANO_POBLACION / 2; i++) {
            nuevaPoblacion.add(individuos.get(i));
        }

        // Generar nuevos individuos por cruce y mutación
        while (nuevaPoblacion.size() < TAMANO_POBLACION) {
            Individuo padre1 = individuos.get(random.nextInt(TAMANO_POBLACION / 2));
            Individuo padre2 = individuos.get(random.nextInt(TAMANO_POBLACION / 2));
            Individuo hijo = cruzar(padre1, padre2);
            mutar(hijo);
            nuevaPoblacion.add(hijo);
        }

        individuos = nuevaPoblacion;
    }

    // Obtener el mejor individuo
    public Individuo getMejorIndividuo() {
        return individuos.get(0);
    }

}
