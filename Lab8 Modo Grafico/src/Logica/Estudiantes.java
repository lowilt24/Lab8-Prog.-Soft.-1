package Logica;

public class Estudiantes {
    private String nombre;
    private String cedula;
    private String carrera;
    private double indiceAcademico;
    private String sexo; // Nuevo atributo

    public Estudiantes(String nombre, String cedula, String carrera, double indiceAcademico, String sexo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.carrera = carrera;
        this.indiceAcademico = indiceAcademico;
        this.sexo = sexo; // Asignación del nuevo atributo
    }

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getSexo() { // Getter para el nuevo atributo
        return sexo;
    }

    public String getCarrera() { // Getter para el nuevo atributo
        return sexo;
    }
}