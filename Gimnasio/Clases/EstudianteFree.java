import java.util.ArrayList;
import java.util.Scanner;

public class EstudianteFree extends Estudiante {
    private TurnoFree turnoReservado;

    // Constructor
    public EstudianteFree(String nombres, String apellidos, long dni, int edad, String codigoEstudiante, String facultad, String membresia, String usuarioGym, String contraseniaGym) {
        super(nombres, apellidos, dni, edad, codigoEstudiante, facultad, "GRATUITO", usuarioGym, contraseniaGym);
    }
    
    public boolean iniciar_sesion_estudiantefree(int intento) {
        String usuario1;
        String contrasenia1;
        Scanner consola = new Scanner(System.in);


        System.out.println("\n**********************************************");
        System.out.println("\t\tIniciar Sesion ");
        
        System.out.print("\n\tUsuario: ");
        usuario1 = consola.nextLine();
        
        System.out.print("\n\tContrasenia: ");
        contrasenia1 = consola.nextLine();
    
        if (this.usuarioGym.equals(usuario1) && this.contraseniaGym.equals(contrasenia1)) {
            System.out.println("\nInicio de sesion exitoso.");
            System.out.println("\tBIENVENIDO ESTUDIANTE FREE");
            return true;
        } else {
            intento--;
            System.out.println("\nUsuario y/o clave incorrectos");
            System.out.println("Le quedan " + intento + " intentos.");
            return false;
        }
    }
    
    // Método para reservar turno
    public void reservarTurno() {
        Scanner scanner = new Scanner(System.in);
        TurnoFree.mostrarTurnos();
        System.out.print("Seleccione el turno (número): ");
        int opcion = scanner.nextInt();
        turnoReservado = TurnoFree.seleccionarTurno(opcion);
        if (turnoReservado != null) {
            if (turnoReservado.reservarCupo(this)) {
                System.out.println("Turno reservado exitosamente.");
            } else {
                System.out.println("No se pudo reservar el turno. Capacidad máxima alcanzada.");
                turnoReservado = null; // No se reserva el turno si no hay cupo
            }
        }
    }

 
    
    // Método para mostrar el turno reservado
    public void mostrarTurno() {
        if (turnoReservado != null) {
            System.out.println("Turno reservado: " + turnoReservado.getHorario());
        } else {
            System.out.println("No tiene un turno reservado.");
        }
    }
    

    // Método para mostrar datos
    public void mostrarDatos() {
        String[][] data = {
            {"Dato", "Información"},
            {"Nombre", getNombres()},
            {"Apellidos", getApellidos()},
            {"Código", getCodigoEstudiante()},
            {"Facultad", getFacultad()},
            {"Membresía", "GRATUITO"}
        };
        imprimirTabla(data);
    }

    // Método para imprimir tabla
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

    // Método para imprimir separador
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