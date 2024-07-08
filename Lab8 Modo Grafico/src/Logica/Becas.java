package Logica;

import java.util.ArrayList;

public class Becas {
    private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }

    public ArrayList<String> obtenerEstudiantesBecados() {
        ArrayList<String> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                estudiantesBecados.add(estudiante.getNombre());
            }
        }

        return estudiantesBecados;
    }


    public Estudiantes buscarEstudiantePorCedula(String cedula) {
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public ArrayList<String> obtenerEstudiantesFiltrados(String carrera, String sexo) {
        ArrayList<String> estudiantesFiltrados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                boolean cumpleCarrera = carrera == null || carrera.isEmpty() || estudiante.getCarrera().equalsIgnoreCase(carrera);
                boolean cumpleSexo = sexo == null || sexo.isEmpty() || estudiante.getSexo().equalsIgnoreCase(sexo);

                if (cumpleCarrera && cumpleSexo) {
                    estudiantesFiltrados.add(estudiante.getNombre());
                }
            }
        }

        return estudiantesFiltrados;
    }
}

}

