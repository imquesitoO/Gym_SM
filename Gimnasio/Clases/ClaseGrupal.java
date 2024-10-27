package gimnasio;

import java.util.List;

public class ClaseGrupal {
    private String nombre;
    private String tipo;
    private String horario;
    private Entrenador entrenador;
    private List<Estudiante> clientesInscritos;

    public ClaseGrupal(String nombre, String tipo, String horario, Entrenador entrenador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horario = horario;
        this.entrenador = entrenador;
    }

    public void inscribirCliente(Estudiante cliente) {
        clientesInscritos.add(cliente);
    }

    public List<Estudiante> mostrarParticipantes() {
        return clientesInscritos;
    }

    public boolean consultarDisponibilidad() {
        
        return true;
    }
}
