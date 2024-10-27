
public class Main {

    public static void main(String[] args) {
        
        Persona entrenador1 = new Entrenador("Luis Fernando", "Gomez Rivas", 98765432, 35, "Masculino", "luis_admin", "strongPass2024");
        Persona entrenador2 = new Entrenador("Carlos Alberto", "Sanchez Torres", 12349876, 42, "Masculino", "carlos_trainer", "trainStrong2024");
        Persona administrador = new Administrador("AdministradorSM","adminPass2024");

        int opc;
        opc = Menu_1();
        
        switch(opc) {
            case 1: {
                int intento = 3;
                boolean ingresado = false;
                do {
                    iniciar_sesion_administrador(ingresado, intento); 
                    intento--;
                } while (intento != 0 && !ingresado);

                if (ingresado) {
                    int opc1;
                    do {
                        opc1 = submenu_admin(); 
                        switch (opc1) {
                            case 1: {
                                registrar_gymrat();
                                break;
                            }
                            case 2: {
                                mostrar_gymrat();
                                break;
                            }
                            case 3: {
                                actualizar_gymrat();
                                break;
                            }
                            case 4: {
                                eliminar_gymrat();
                                break;
                            }
                            case 5:
                                break;
                            default: {
                                System.out.println("\n\tOpción no válida");
                                System.out.println("Presione enter para volver a seleccionar...");
                                break;
                            }
                        }
                    } while (opc1 != 5);
                }
                break;
            }

            case 2: {
                int intento = 3;
                boolean ingresado = false;
                do {
                    iniciar_sesion_entrenador(ingresado, intento); 
                    intento--;
                } while (intento != 0 && !ingresado);
                
                if (ingresado) {
                    int opc2;
                    do {
                        opc2 = submenu_entrenador();
                        switch (opc2) {
                            case 1: {
                                alumnos_registrados();
                                break;
                            }
                            case 2:
                                break;
                            default: {
                                System.out.println("\n\tOpción no válida");
                                System.out.print("Presione enter para volver a seleccionar...");
                                break;
                            }
                        }
                    } while (opc2 != 3);
                }
                break;
            }

            case 3: { 
                int intento = 3;
                boolean ingresado = false;
                do {
                    iniciar_sesion_gymrat(ingresado, intento); 
                    intento--;
                } while (intento != 0 && !ingresado);

                if (ingresado) {
                    int opc3;
                    do {
                        opc3 = submenu_gymrat();
                        switch (opc3) {
                            case 1: {
                                reservarTurno();
                                break;
                            }
                            case 2: {
                                ver_entrenador();
                                break;
                            }
                            case 3:
                                break;
                            default: {
                                System.out.print("\n\tOpción no válida");
                                System.out.println("\nPresione enter para volver a seleccionar...");
                                break;
                            }
                        }
                    } while (opc3 != 3);
                }
                break;
            }
            
            case 4:
                break;
                
            default:
                System.out.println("\n\tOpción no válida en el menú principal.");
                break;
        }
    }


public static int Menu_1(){
        Scanner consola= new Scanner(System.in);
        System.out.println("\tBIENVENIDO AL SMFit");
        System.out.format("\n[1].Administrador\n[2].Entrenador\n[3].Gymrat\n[4]Salir\nSeleccione una opcion: ");
        int opc=consola.nextInt();
        return opc;
    }
}