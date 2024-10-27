package gimnasio;

public class Administrador extends Persona {
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
    
    public void Mostrar_Alumno(String codigo){
        String id=codigo;
        if(id.equals( getCodigoGymrat())|| id.equals(getUsuarioGymRat())){
            
        }
    }
    public void Mostrar_Datos(){
        String [][] datos= {{"Usuario", usuario}, {"Nombre ",getNombres()}, { "Apellidos ",getApellidos()}, {"DNI ",String.valueOf(getDni())}, {"Edad", String.valueOf(getEdad())}};
        imprimirTabla(datos);
    }
    
    public static void imprimirTabla(String[][] datos) {
        int anchoColumna1 = 20; // Ajusta según la longitud de los textos en la primera columna
        int anchoColumna2 = 30; // Ajusta según la longitud de los textos en la segunda columna

        // Imprime la línea superior de la tabla
        imprimirLinea(anchoColumna1, anchoColumna2);

        // Imprime cada fila de datos
        for (String[] fila : datos) {
            System.out.printf("| %-"+(anchoColumna1-2)+"s | %-"+(anchoColumna2-2)+"s |%n", fila[0], fila[1]);
            imprimirLinea(anchoColumna1, anchoColumna2);
        }
    }

    public static void imprimirLinea(int anchoColumna1, int anchoColumna2) {
        System.out.print("+");
        for (int i = 0; i < anchoColumna1; i++) System.out.print("-");
        System.out.print("+");
        for (int i = 0; i < anchoColumna2; i++) System.out.print("-");
        System.out.println("+");
    }
    
}