package gimnasio;
public class Persona {
    protected  String nombre;
    protected  String apellidos;
    protected  long dni;
    protected  int edad;
    protected  String genero;


    public Persona(String nombre, String apellidos, long dni, int edad, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad=edad;
        this.genero=genero; }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
