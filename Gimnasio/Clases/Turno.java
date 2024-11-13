import java.util.ArrayList;
import java.util.Scanner;

abstract class Turno {
    private String horario;
    private int capacidadMaxima;
    private int usuariosRegistrados;

    public Turno(String horario, int capacidadMaxima) {
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.usuariosRegistrados = 0;
    }

    public String getHorario() {
        return horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getUsuariosRegistrados() { 
        return usuariosRegistrados;
    }

    public boolean registrarUsuario() {
        if (usuariosRegistrados < capacidadMaxima) {
            usuariosRegistrados++;
            return true;
        }
        return false;
    }

    public abstract boolean reservarCupo(Estudiante estudiante);
}
