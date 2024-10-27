public class Entrenador extends Persona {
    private String usuarioEntrenador;
    private String contraseniaEntrenador;

    public Entrenador(String nombres, String apellidos, long dni, int edad, String genero, String usuarioEntrenador, String contraseniaEntrenador) {
        super(nombres, apellidos, dni, edad, genero);
        this.usuarioEntrenador = usuarioEntrenador;
        this.contraseniaEntrenador = contraseniaEntrenador;
    }
    
    public String getUsuarioEntrenador() {
        return usuarioEntrenador;
    }

    public void setUsuarioEntrenador(String usuarioEntrenador) {
        this.usuarioEntrenador = usuarioEntrenador;
    }

    public String getContraseniaEntrenador() {
        return contraseniaEntrenador;
    }

    public void setContraseniaEntrenador(String contraseniaEntrenador) {
        this.contraseniaEntrenador = contraseniaEntrenador;
    }
    
}
