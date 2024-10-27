/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasio;

public class Gimnasio {
    private Estudiante[] estudiantes;
    private Entrenador[] entrenadores;
    private Membresia[] membresias;
  
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

    public void agregarEntrenador(Entrenador entrenador) {
        for (int i = 0; i < entrenadores.length; i++) {
            if (entrenadores[i] == null) {
                entrenadores[i] = entrenador;
                break;
            }
        }
    }

    public void agregarMembresia(Membresia membresia) {
        for (int i = 0; i < membresias.length; i++) {
            if (membresias[i] == null) {
                membresias[i] = membresia;
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

    public Membresia[] getMembresias() {
        return membresias;
    }

}
