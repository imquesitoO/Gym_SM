package gimnasio;

public class Entrenador extends Persona {
    private String especialidad;


    public Entrenador(String nombres, String apellidos, long dni, int edad, String genero, String especialidad) {
        super(nombres, apellidos, dni, edad, genero);
        this.especialidad = especialidad;
    }


    public String getEspecialidad() {
        return especialidad;
    }


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
