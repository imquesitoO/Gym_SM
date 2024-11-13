import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();

        Entrenador [] entrenadores = {
            new Entrenador("Luis", "Gomez Carrillo", 98765432, 35, "luis_admin", "luis1234"),
            new Entrenador("Carlos", "Sanchez Olaya", 12349876, 42, "carlos_trainer", "carlos1234")
        };
        
        //Estudiante[] estudiantes = new Estudiante[100];
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
      
        TurnoFree.inicializarTurnos();
        TurnoPremium.inicializarTurnos();

        Scanner scanner = new Scanner(System.in);
        int opc;
        do {
            opc = Sub_menu.Menu_1();
            switch (opc) {
                case 1 -> {
                    int intentos = 3;
                    boolean ingresado = administrador.iniciarSesionAdministrador(intentos);
                    if (ingresado) {
                        int opc1;
                        do {
                            opc1 = Sub_menu.submenu_admin();
                            switch (opc1) {
                                case 1 -> administrador.registrar_estudiante(estudiantes);
                                case 2 -> {
                                    int pos = administrador.buscar_estudiante(estudiantes);
                                    administrador.mostrar_estudiante(estudiantes, pos);
                                }
                                case 3 -> {
                                    int pos = administrador.buscar_estudiante(estudiantes);
                                    administrador.actualizar_estudiante(estudiantes, pos);
                                }
                                case 4 -> {
                                    int pos = administrador.buscar_estudiante(estudiantes);
                                    administrador.eliminar_estudiante(estudiantes,pos);
                                }
                                case 5 -> administrador.mostrar_entrenador((Entrenador[]) entrenadores);
                                case 6 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no valida.");
                            }
                        } while (opc1 != 6);
                    } else {
                        System.out.println("No se pudo iniciar sesión como administrador.");
                    }
                }

                case 2 -> {
                    int intento = 3;
                    boolean ingresado = false;
                    do {
                        ingresado = Entrenador.iniciar_sesion_entrenador(intento, (Entrenador[]) entrenadores);
                        intento--;
                    } while (intento != 0 && !ingresado);

                    if (ingresado) {
                        int opc2;
                        do {
                            opc2 = Sub_menu.submenu_entrenador();
                            switch (opc2) {
                                case 1 -> {
                                    System.out.println("Lista de Estudiantes Premium:");
                                    entrenadores[0].mostrarEstudiante( (ArrayList<Estudiante>) estudiantes);
                                }
                                case 2 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no valida.");
                            }
                        } while (opc2 != 2);
                    }
                }

                case 3 -> {
                    int intento = 3;
                    boolean ingresado = false;
                    Estudiante estudianteActivo = null;
                    do {
                        for (Estudiante estudiante : estudiantes) {
                            if (estudiante instanceof EstudianteFree) {
                                ingresado = ((EstudianteFree) estudiante).iniciar_sesion_estudiantefree(intento);
                                if (ingresado) {
                                    estudianteActivo = estudiante;
                                    break;
                                }
                            }
                        }
                        intento--;
                    } while (intento != 0 && !ingresado);

                    if (ingresado && estudianteActivo != null) {
                        int opc3;
                        do {
                            opc3 = Sub_menu.submenu_estudianteFree();
                            switch (opc3) {
                                case 1 -> ((EstudianteFree) estudianteActivo).reservarTurno();
                                case 2 -> ((EstudianteFree) estudianteActivo).mostrarTurno();
                                case 3 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no valida.");
                            }
                        } while (opc3 != 3);
                    }
                }

                case 4 -> {
                    int intento = 3;
                    boolean ingresado = false;
                    Estudiante estudianteActivo = null;
                    do {
                        for (Estudiante estudiante : estudiantes) {
                            if (estudiante instanceof EstudiantePremium) {
                                ingresado = ((EstudiantePremium) estudiante).iniciar_sesion_estudiantepremium(intento);
                                if (ingresado) {
                                    estudianteActivo = estudiante;
                                    break;
                                }
                            }
                        }
                        intento--;
                    } while (intento != 0 && !ingresado);

                    if (ingresado && estudianteActivo != null) {
                        int opc4;
                        do {
                            opc4 = Sub_menu.submenu_estudiantePremium();
                            switch (opc4) {
                                case 1 -> ((EstudiantePremium) estudianteActivo).reservarTurno();
                                case 2 -> ((EstudiantePremium) estudianteActivo).mostrarTurno();
                                case 3 -> {
                                    System.out.println("Entrenadores disponibles:");
                                    for (Persona entrenador : entrenadores) {
                                        System.out.println(entrenador.getNombres() + " " + entrenador.getApellidos());
                                    }
                                }
                                case 4 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no valida.");
                            }
                        } while (opc4 != 4);
                    }
                }

                case 5 -> System.out.println("\nSaliendo...");
                default -> System.out.println("\n\tOpcion no válida en el menu principal.");
            }
        } while (opc != 5);
        scanner.close();
        Sub_menu.cerrarScanner();
    }
}