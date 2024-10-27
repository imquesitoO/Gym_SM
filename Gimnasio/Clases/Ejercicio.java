package gimnasio;

public class Ejercicio {
    private String nombre;
    private String tipo;
    private String musculoPrincipal;
    private String musculoSecundario;
    private int repeticiones;
    private int series;
    private int descanso;

    public Ejercicio(String nombre, String tipo, String musculoPrincipal, String musculoSecundario, int repeticiones, int series, int descanso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.musculoPrincipal = musculoPrincipal;
        this.musculoSecundario = musculoSecundario;
        this.repeticiones = repeticiones;
        this.series = series;
        this.descanso = descanso;
    }

    public void mostrarDetalles() {
        System.out.println("Ejercicio: " + nombre + ", Reps: " + repeticiones + ", Series: " + series + ", Descanso: " + descanso + " seg");
    }

    public void modificarEjercicio(String nuevoNombre, String nuevoTipo, String nuevoMusculoPrincipal, String nuevoMusculoSecundario, int nuevasRepeticiones, int nuevasSeries, int nuevoDescanso) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        
        if (nuevoTipo != null && !nuevoTipo.isEmpty()) {
            this.tipo = nuevoTipo;
        }
        
        if (nuevoMusculoPrincipal != null && !nuevoMusculoPrincipal.isEmpty()) {
            this.musculoPrincipal = nuevoMusculoPrincipal;
        }
        
        if (nuevoMusculoSecundario != null && !nuevoMusculoSecundario.isEmpty()) {
            this.musculoSecundario = nuevoMusculoSecundario;
        }
        
        if (nuevasRepeticiones > 0) {
            this.repeticiones = nuevasRepeticiones;
        }
        
        if (nuevasSeries > 0) {
            this.series = nuevasSeries;
        }
        
        if (nuevoDescanso > 0) {
            this.descanso = nuevoDescanso;
        }
        
        System.out.println("El ejercicio ha sido modificado exitosamente.");
    }
}
