import java.util.Scanner;

public class Sub_menu {
    private static Scanner consola = new Scanner(System.in);

    public static int Menu_1() {
        System.out.println("\tBIENVENIDO AL SMFit");
        System.out.println("\n[1] Administrador");
        System.out.println("[2] Entrenador");
        System.out.println("[3] Estudiante Free");
        System.out.println("[4] Estudiante Premium");
        System.out.println("[5] Salir");
        System.out.print("Seleccione una opcion: ");
        int opc = consola.nextInt();
        consola.nextLine(); // Limpiar el buffer
        return opc;
    }

    public static int submenu_admin() {
        System.out.println("[1] Registrar nuevo Estudiante");
        System.out.println("[2] Mostrar Estudiante");
        System.out.println("[3] Actualizar los datos");
        System.out.println("[4] Eliminar Estudiante");
        System.out.println("[5] Mostrar entrenadores");
        System.out.println("[6] Regresar");
        System.out.print("Seleccione una opcion: ");
        int opc1 = consola.nextInt();
        consola.nextLine(); // Limpiar el buffer
        return opc1;
    }

    public static int submenu_entrenador() {
        System.out.println("[1] Mostrar lista de Estudiantes Premium asignados");
        System.out.println("[2] Regresar");
        System.out.print("Seleccione una opcion: ");
        int opc2 = consola.nextInt();
        consola.nextLine(); // Limpiar el buffer
        return opc2;
    }

public static int submenu_estudianteFree() {
    Scanner consola = new Scanner(System.in); // Asegúrate de que el Scanner esté correctamente inicializado

    System.out.println("[1] Reservar turno");
    System.out.println("[2] Ver turno reservado");
    System.out.println("[3] Regresar");
    System.out.print("Seleccione una opcion: ");
    
    int opc3 = consola.nextInt(); // Leer la opción seleccionada
    consola.nextLine(); // Limpiar el buffer
    return opc3;
}


    public static int submenu_estudiantePremium() {
        System.out.println("[1] Reservar turno");
        System.out.println("[2] Ver turno reservado");
        System.out.println("[3] Mostrar entrenadores");
        System.out.println("[4] Regresar");
        System.out.print("Seleccione una opcion: ");
        int opc4 = consola.nextInt();
        consola.nextLine(); // Limpiar el buffer
        return opc4;
    }

    public static int actualizar_usuario() {
        System.out.println("[1] Nombre");
        System.out.println("[2] Apellido");
        System.out.println("[3] Usuario");
        System.out.println("[4] Contrasenia");
        System.out.println("[5] Membresia");
        System.out.println("[6] Regresar");
        System.out.print("Seleccione una opcion: ");
        int opc5 = consola.nextInt();
        consola.nextLine(); // Limpiar el buffer
        return opc5;
    }

    public static void cerrarScanner() {
        consola.close();
    }
}