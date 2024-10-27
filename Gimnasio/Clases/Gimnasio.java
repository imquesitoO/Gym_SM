/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

public class Gimnasio {
    private Estudiante[] estudiantes;
    private Entrenador[] entrenadores;
  
    public Gimnasio(int maxEstudiantes, int maxEntrenadores, int maxMembresias, int maxRutinas) {
        this.estudiantes = new Estudiante[maxEstudiantes];
        this.entrenadores = new Entrenador[maxEntrenadores];
        this.membresias = new Membresia[maxMembresias];
    }

    public void agregarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }
    class Gimnasio {
    private Entrenador[] entrenadores;
    private Alumno[] alumnos;

    // Constructor
    public Gimnasio(Entrenador[] entrenadores, Alumno[] alumnos) {
        this.entrenadores = entrenadores;
        this.alumnos = alumnos;
    }

    public void mostrarAlumno(String codigo) {
        for (Alumno alumno : alumnos) {
            String id = codigo;
            if (id.equals(alumno.getCodigoGymrat()) || id.equals(alumno.getUsuarioGymRat())) {
                System.out.println("\tINFORMACIÓN DEL ALUMNO");
                alumno.mostrarInformacion(); 
                return; 
            }
        }
        System.out.println("Alumno no encontrado...");
    }

    public void mostrarEntrenadores() {
        System.out.println("\tLISTA DE ENTRENADORES");
        for (Entrenador entrenador : entrenadores) {
            System.out.println("Entrenador: " + entrenador.getNombre()+entrenador.getApellidos);
        }
    }
}
