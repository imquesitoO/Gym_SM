import static com.mycompany.Gimnasio.Administrador.imprimirTabla;
import java.util.Scanner;
import java.util.ArrayList;

public class Entrenador extends Persona implements Manejo_Archivos,Salida {

    private String usuarioEntrenador;
    private String contraseniaEntrenador;
    private String[] alumnosAsignados;


    public Entrenador(String nombres, String apellidos, long dni, int edad, 
                      String usuarioEntrenador, String contraseniaEntrenador) {
        super(nombres, apellidos, dni, edad);
        this.usuarioEntrenador = usuarioEntrenador;
        this.contraseniaEntrenador = contraseniaEntrenador;
        this.alumnosAsignados = new String[5]; // Inicializamos el array con 5 espacios
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


    public String[] getAlumnosAsignados() {
        return alumnosAsignados;
    }


    public void setAlumnosAsignados(String[] alumnosAsignados) {
        this.alumnosAsignados = alumnosAsignados;
    }


    public void asignarAlumnos(String[] nuevosAlumnos) {
        if (nuevosAlumnos.length != 5) {
            System.out.println("Error: Debe asignar exactamente 5 alumnos.");
            return;
        }
        this.alumnosAsignados = nuevosAlumnos;
        System.out.println("Alumnos asignados correctamente.");
    }
    
    public static boolean iniciar_sesion_entrenador(int intentos, Entrenador[] entrenadores) {
        Scanner consola = new Scanner(System.in);


        System.out.println("\n**********************************************");
        System.out.println("\t\tIniciar Sesion");


        System.out.print("\n\tUsuario: ");
        String usuario1 = consola.nextLine();


        System.out.print("\n\tContrasenia: ");
        String contrasenia1 = consola.nextLine();


        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getUsuarioEntrenador().equals(usuario1) &&
                entrenador.getContraseniaEntrenador().equals(contrasenia1)) {
                
                System.out.println("\nInicio de sesion exitoso.");
                System.out.println("\tBIENVENIDO ENTRENADOR");


                String[][] data = {
                    {"Dato", "Informacion"},
                    {"Nombre", entrenador.getNombres()},
                    {"Apellidos", entrenador.getApellidos()}
                };
                
                imprimirTabla(data);
                
                return true;
            }
        }
        intentos--;
        System.out.println("\nUsuario y/o clave incorrectos");
        System.out.println("Le quedan " + intentos + " intentos.");
        return false;
    }
    
    
   public void mostrarEstudiante(ArrayList<Estudiante> estudiantes) {
    estudiantes.clear();  // Limpia la lista para evitar duplicados.

    // Cargar estudiantes Free y Premium.
    cargarEstudiantesFree(estudiantes);
    cargarEstudiantesPremium(estudiantes);

    // Verificar que haya estudiantes cargados.
    if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes cargados para mostrar.");
        return;
    }

    // Mostrar solo estudiantes PREMIUM.
    for (Estudiante e : estudiantes) {
        if ("PREMIUM".equals(e.getMembresia())) {
            String[][] data = {
                {"Dato", "Informacion"},
                {"Nombre", quitarEspacio(e.getNombres())},
                {"Apellidos", quitarEspacio(e.getApellidos())}
            };
            imprimirTabla(data);
        }
    }
}


    public static void imprimirTabla(String[][] data) {
        int anchoColumna1 = 15;
        int anchoColumna2 = 25;


        imprimirSeparador(anchoColumna1, anchoColumna2);
        System.out.printf("| %-"+ (anchoColumna1 - 1) +"s| %-"+ (anchoColumna2 - 1) +"s|\n", data[0][0], data[0][1]);
        imprimirSeparador(anchoColumna1, anchoColumna2);


        for (int i = 1; i < data.length; i++) {
            System.out.printf("| %-"+ (anchoColumna1 - 1) +"s| %-"+ (anchoColumna2 - 1) +"s|\n", data[i][0], data[i][1]);
            imprimirSeparador(anchoColumna1, anchoColumna2);
        }
    }


    public static void imprimirSeparador(int anchoColumna1, int anchoColumna2) {
        System.out.print("+");
        for (int i = 0; i < anchoColumna1; i++) {
            System.out.print("-");
        }
        System.out.print("+");
        for (int i = 0; i < anchoColumna2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
