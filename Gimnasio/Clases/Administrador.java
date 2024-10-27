package gimnasio;

public class Administrador extends Persona {
        private Gimnasio gimnasio
        private String usuario;
        private String contrasenia;

    public Administrador(String nombres, String apellidos, long dni, int edad, String genero,String usuario,String contrasenia) {
        super(nombres, apellidos, dni, edad, genero);
        this.usuario=usuario;
        this.contrasenia=contrasenia;
    }
     public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public void Mostrar_Alumno(){
        //mostrar alumno en especifico
    }
    public void Mostrar_Entrenadores(){
        //mostrar todos los entrenadores
    }
    public void Mostrar_Subscripcion(){
        //mostrar solo alumnos con membresia premium
    }
}
