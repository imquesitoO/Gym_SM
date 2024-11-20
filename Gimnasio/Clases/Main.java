import java.util.Scanner;
import java.util.ArrayList;
public class Main implements Manejo_Archivos{
    public static void main(String[] args) {
        Administrador administrador = new Administrador();

        Entrenador [] entrenadores = {
            new Entrenador("Luis", "Gomez Carrillo", 98765432, 35, "luis_admin", "luis1234"),
            new Entrenador("Carlos", "Sanchez Olaya", 12349876, 42, "carlos_trainer", "carlos1234")
        };
        
        //Estudiante[] estudiantes = new Estudiante[100];
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Estudiante> estudiantesFree = new ArrayList<>();
        ArrayList<Estudiante> estudiantesPremium = new ArrayList<>();
        
      administrador.cargarEstudiantesFree(estudiantesFree);
      administrador.cargarEstudiantesPremium(estudiantesPremium);
      
        if (estudiantesFree.isEmpty()) {
         System.out.println("No se encontraron estudiantes Free.");
        }

        if (estudiantesPremium.isEmpty()) {
        System.out.println("No se encontraron estudiantes Premium.");
        }

      
      
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
                                    administrador.eliminar_estudiante(estudiantes, pos);
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
                    boolean ingresado;
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
                                    entrenadores[0].mostrarEstudiante((ArrayList<Estudiante>) estudiantes);
                                }
                                case 2 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no valida.");
                            }
                        } while (opc2 != 2);
                    }
                }

                case 3 -> {
                    boolean ingresado = false;
                    int intento = 3;
                    EstudianteFree estudianteActivo = null;
                    
                    do {
                            for (Estudiante e : estudiantesFree) {
                                if (e instanceof EstudianteFree) {
                                ingresado = ((EstudianteFree) e).iniciar_sesion_estudiantefree(intento);
                                if (ingresado) {
                                    estudianteActivo = (EstudianteFree) e;
                                    break;
                                }                          
                            }
                        }

                        if (estudianteActivo == null) {
                            System.out.println("Estudiante no encontrado.");
                            intento--;
                            if (intento > 0) {
                                System.out.println("Intentos restantes: " + intento);
                            }
                        } else {
                            System.out.println("\nInicio de sesion exitoso.\n\n");
                            System.out.println("\tBIENVENIDO ESTUDIANTE FREE");
                            ingresado = true;
                            break;
                        }

                    } while (intento > 0 && !ingresado);

                    if (ingresado) {
                        int opc3;
                        do {
                            opc3 = Sub_menu.submenu_estudianteFree();
                            switch (opc3) {
                                case 1 -> estudianteActivo.reservarTurno();
                                case 2 -> estudianteActivo.mostrarTurno();
                                case 3 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no válida.");
                            }
                        } while (opc3 != 3);
                    } else {
                        System.out.println("\nNo se pudo iniciar sesion después de varios intentos. Volviendo al menu principal.");
                    }
                }

                case 4 -> {
                    boolean ingresado = false;
                    int intento = 3;
                    EstudiantePremium estudianteActivo = null;

                     do {
                            for (Estudiante e : estudiantesPremium) {
                                if (e instanceof EstudiantePremium) {
                                ingresado = ((EstudiantePremium) e).iniciar_sesion_estudiantepremium(intento);
                                if (ingresado) {
                                    estudianteActivo = (EstudiantePremium) e;
                                    break;
                                }                          
                            }
                        }

                        if (!ingresado) {
                                estudianteActivo = null; // Restablece a null si no se encuentra
                                intento--;
                                System.out.println("Estudiante no encontrado.");
                                if (intento > 0) {
                                    System.out.println("Intentos restantes: " + intento);
                                }

                        } else {
                            System.out.println("\nInicio de sesion exitoso.\n\n");
                            System.out.println("\tBIENVENIDO ESTUDIANTE FREE");
                            ingresado = true;
                            break;
                        }

                    } while (intento > 0 && !ingresado);

                    if (ingresado) {
                        int opc3;
                        do {
                            opc3 = Sub_menu.submenu_estudiantePremium();
                            switch (opc3) {
                                case 1 -> estudianteActivo.reservarTurno();
                                case 2 -> estudianteActivo.mostrarTurno();
                                case 3 -> estudianteActivo.mostrarEntrenadores((Entrenador[]) entrenadores);
                                case 4 -> System.out.println("\nRegresando al menu principal...");
                                default -> System.out.println("\n\tOpción no válida.");
                            }
                        } while (opc3 != 4);
                    } else {
                        System.out.println("\nNo se pudo iniciar sesion después de varios intentos. Volviendo al menu principal.");
                    }
                }
                case 5 -> System.out.println("\nSaliendo...");
                default -> System.out.println("\n\tOpción no válida en el menu principal.");
            }
        } while (opc != 5);
            scanner.close();
    }
}