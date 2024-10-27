package gimnasio;

public class Gymrat extends Persona {
    private String codigoGymrat;
    private String facultad;
    private String usuarioGym;
    private String contraseniaGym;
    private Membresia membresia;

    public Gymrat(String nombres, String apellidos, long dni, int edad, String genero, String codigoGymrat, String facultad, String usuarioGym, String contraseniaGym) {
        super(nombres, apellidos, dni, edad, genero);
        this.codigoGymrat = codigoGymrat;
        this.facultad = facultad;
        this.usuarioGym=usuarioGym;
        this.contraseniaGym=contraseniaGym;
    }
    
    public String getCodigoGymrat() {
        return codigoGymrat;
    }

    public void setCodigoGymrat(String codigoGymrat) {
        this.codigoGymrat = codigoGymrat;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
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

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}

