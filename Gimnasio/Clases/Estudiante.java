import java.io.*;

/**
 *
 * @author valer
 */
public class Estudiante extends Persona implements Serializable {
    
     protected String codigoEstudiante;
    protected String facultad;
    protected String membresia; //premium o mortal
    protected String usuarioGym;
    protected String contraseniaGym;

    
    //constructor de estudiante
    public Estudiante(String nombres, String apellidos, long dni, int edad, String codigoEstudiante, String facultad, String membresia, String usuarioGym, String contraseniaGym) {
        super(nombres, apellidos, dni, edad);
        this.codigoEstudiante = codigoEstudiante;
        this.facultad = facultad;
        this.membresia = membresia;
        this.usuarioGym=usuarioGym;
        this.contraseniaGym=contraseniaGym;
    }

   //metodos setters y getters

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public String getUsuarioGym() {
        return usuarioGym;
    }

    public void setUsuarioGym(String usuarioGym) {
        this.usuarioGym = usuarioGym;
    }

    public String getContraseniaGym() {
        return contraseniaGym;
    }

    public void setContraseniaGym(String contraseniaGym) {
        this.contraseniaGym = contraseniaGym;
    }
    
    //metodo mostrar datos
    public void mostrarDatos(){
    }
    
    @Override
    public String toString() {
    return nombres + ',' +
           apellidos + ',' +
           dni + ',' +
           edad +',' +
           codigoEstudiante + ',' +
           facultad + ',' +
           usuarioGym + ',' +
           contraseniaGym + ',' +
           membresia + ',';
    }
}