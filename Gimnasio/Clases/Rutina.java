package gimnasio;

import java.util.List;

public class Rutina {
    private String nombre;
    private List<Ejercicio> ejercicios;
    private int duracion; // en minutos
    private String nivelExperiencia;
    private String objetivo;

    public Rutina(String nombre, List<Ejercicio> ejercicios, int duracion, String nivelExperiencia, String objetivo) {
        this.nombre = nombre;
        this.ejercicios = ejercicios;
        this.duracion = duracion;
        this.nivelExperiencia = nivelExperiencia;
        this.objetivo = objetivo;
    }

    public void mostrarRutina() {
        System.out.println("Rutina: " + nombre);
        for (Ejercicio ejercicio : ejercicios) {
            ejercicio.mostrarDetalles();
        }
    }

    public void modificarRutina(String nuevoNombre, List<Ejercicio> nuevosEjercicios, int nuevaDuracion, String nuevoNivelExperiencia, String nuevoObjetivo) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }

        if (nuevosEjercicios != null && !nuevosEjercicios.isEmpty()) {
            this.ejercicios = nuevosEjercicios;
        }
        
        if (nuevaDuracion > 0) {
            this.duracion = nuevaDuracion;
        }
        
        if (nuevoNivelExperiencia != null && !nuevoNivelExperiencia.isEmpty()) {
            this.nivelExperiencia = nuevoNivelExperiencia;
        }
        
        if (nuevoObjetivo != null && !nuevoObjetivo.isEmpty()) {
            this.objetivo = nuevoObjetivo;
        }
        
        System.out.println("La rutina ha sido modificada exitosamente.");
    }

    public void agregarEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
    }

    public void eliminarEjercicio(Ejercicio ejercicio) {
        ejercicios.remove(ejercicio);
    }
}
