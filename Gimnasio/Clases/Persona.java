public abstract class Persona {
    protected  String nombres;
    protected  String apellidos;
    protected  long dni;
    protected  int edad;


    public Persona(String nombres, String apellidos, long dni, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad=edad;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
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
        
}