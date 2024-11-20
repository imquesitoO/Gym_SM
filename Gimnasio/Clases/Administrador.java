import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Administrador implements Salida, Manejo_Archivos {
    private String usuario;
    private String contrasenia;
    
    
    public Administrador() {
        this.usuario = "Fisiadmin";
        this.contrasenia = "admin1234";
    }
    
    
    public boolean iniciarSesionAdministrador(int intentos) {
        Scanner consola = new Scanner(System.in);

        System.out.println("\n**********************************************");
        System.out.println("\t\tIniciar Sesion ");

        while (intentos > 0) {
            try {
                System.out.print("\n\tUsuario: ");
                String usuario1 = consola.nextLine();

                System.out.print("\n\tContrasenia: ");
                String contrasenia1 = consola.nextLine();

                if (this.usuario.equals(usuario1) && this.contrasenia.equals(contrasenia1)) {
                    System.out.println("\nInicio de sesion exitoso.\n\n");
                    System.out.println("\tBIENVENIDO ADMINISTRADOR");
                    return true; // Regresa verdadero si el inicio de sesión es exitoso
                } else {
                    intentos--; // Reduce el número de intentos
                    System.out.println("\nUsuario y/o clave incorrectos");
                    System.out.println("Le quedan " + intentos + " intentos.");
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                break;
            }
        }

        System.out.println("Se han agotado los intentos de inicio de sesion.");
        return false; // Regresa falso si se agotan los intentos
    }
    

    
    public void registrar_estudiante(ArrayList<Estudiante> estudiantes) {
        
        Scanner console = new Scanner(System.in);
        
        int edad = 0;
        String nombre;
        String apellido;
        String facultad;
        String usuariO;
        String contraseniA;
        String codigo;
        String membresia = null;
        long dni = 0;

        System.out.println("\nRegistrando los datos...");

        System.out.print("Nombre: ");
        nombre = console.nextLine();

        System.out.print("Apellido: ");
        apellido = console.nextLine();

        // Manejo de excepción específico para DNI
        boolean dniValido = false;
        while (!dniValido) {
            try {
                System.out.print("DNI: ");
                dni = console.nextLong();
                console.nextLine(); // Limpiar el buffer después de nextLong()
                dniValido = true; // Salir del bucle si es válido
            } catch (InputMismatchException e) {
                System.out.println("Error: DNI debe ser un número entero.");
                console.nextLine(); // Limpiar el buffer
            }
        }

        // Manejo de excepción específico para Edad
        boolean edadValida = false;
        while (!edadValida) {
            try {
                System.out.print("Edad: ");
                edad = console.nextInt();
                console.nextLine(); // Limpiar el buffer después de nextInt()
                edadValida = true; // Salir del bucle si es válido
            } catch (InputMismatchException e) {
                System.out.println("Error: Edad debe ser un número entero.");
                console.nextLine(); // Limpiar el buffer
            }
        }

        System.out.print("Codigo: ");
        codigo = console.nextLine();
        
        System.out.print("Facultad: ");
        facultad = console.nextLine();
        
        System.out.print("Usuario: ");
        usuariO = console.nextLine();

        System.out.print("Contrasenia: ");
        contraseniA = console.nextLine();

        // Validación de membresía específica
        boolean membresiaValida = false;
        while (!membresiaValida) {
            System.out.print("Membresia (GRATUITO o PREMIUM): ");
            membresia = console.nextLine().toUpperCase();

            if (membresia.equals("GRATUITO") || membresia.equals("PREMIUM")) {
                membresiaValida = true; // Salir del bucle si es válido
            } else {
                System.out.println("Error: La membresía debe ser 'GRATUITO' o 'PREMIUM'.");
            }
        }
        
        nombre=quitarEspacio(nombre);
        apellido=quitarEspacio(apellido);
        facultad=quitarEspacio(facultad);
        
        LocalDate fechaActual = LocalDate.now();
        System.out.println("\nFecha actual: " + fechaActual);

        
        if(membresia.equals("GRATUITO")){
            estudiantes.add(new EstudianteFree(nombre, apellido, dni, edad, codigo, facultad, membresia, usuariO, contraseniA));
            agregar_estudianteFree(estudiantes);
        }
        
        else{
           estudiantes.add(new EstudiantePremium(nombre, apellido, dni, edad, codigo, facultad, membresia, usuariO, contraseniA));
           agregar_estudiantePremium(estudiantes);
           System.out.println("\nRecordar: Membresia Premium: 15 soles");
        }

        System.out.println("\tUsuario registrado");
        
}
    
        
    
// Suponiendo que estudiantes ya está cargado antes de llamar a esta función
    public int buscar_estudiante(ArrayList<Estudiante> estudiantes) {
    // Cargar los estudiantes solo una vez al principio
    cargarEstudiantesFree(estudiantes);
    cargarEstudiantesPremium(estudiantes);

    Scanner console = new Scanner(System.in);
    System.out.print("\n\tDigite el Usuario o Codigo del usuario a buscar: ");
    String codigo = console.nextLine();

    // Si no se han cargado estudiantes, podemos manejarlo aquí
    if (estudiantes.isEmpty()) {
        System.out.println("No se han cargado estudiantes.");
        return -1;
    }

    // Usar for-each para recorrer los estudiantes
    int pos = 0;
    for (Estudiante e : estudiantes) {
        if (e != null && e.getCodigoEstudiante().equals(codigo)) { // Verificar que e no sea null
            return pos;
        }
        pos++;
    }

    // Si no se encuentra el estudiante, retornar -1
    return -1;
    }

             
     // Método para mostrar la información del estudiante encontrado
    public void mostrar_estudiante(ArrayList<Estudiante> estudiantes, int pos) {
        if (pos == -1) {
            System.out.println("\nUsuario no encontrado...");
        } else {

            String[][] data = {
                {"Dato", "Informacion"},
                {"Nombre", agregarEspacio(estudiantes.get(pos).getNombres())},
                {"Apellidos", agregarEspacio(estudiantes.get(pos).getApellidos())},
                {"Codigo", estudiantes.get(pos).getCodigoEstudiante()},
                {"Facultad", agregarEspacio(estudiantes.get(pos).getFacultad())},
                {"Membresia", estudiantes.get(pos).getMembresia()},
            };
            imprimirTabla(data);
        }
        
    }
    
    
     public void actualizar_estudiante(ArrayList<Estudiante> estudiantes, int pos) {
        int i=0;
        Scanner console = new Scanner(System.in);
        if (pos == -1 || pos >= estudiantes.size()) {
            System.out.println("Usuario no encontrado...");
            return;
        }

        Estudiante estudiante = estudiantes.get(pos);
        String membresia = estudiante.getMembresia(); // Guardamos la membresía actual para usarla más tarde

        int opc = Sub_menu.actualizar_usuario();
        switch (opc) {
            case 1 -> {
                System.out.println("Nombre actual: " + agregarEspacio(estudiante.getNombres()));
                System.out.print("Digite el nuevo nombre: ");
                String nombre = console.nextLine();
                nombre=quitarEspacio(nombre);
                estudiante.setNombres(nombre);
                System.out.println("Nombre actualizado.");
            }
            case 2 -> {
                System.out.println("Apellidos actuales: " + agregarEspacio(estudiante.getApellidos()));
                System.out.print("Digite el nuevo apellido: ");
                String apellido = console.nextLine();
                apellido=quitarEspacio(apellido);
                estudiante.setApellidos(apellido);
                System.out.println("Apellido actualizado.");
            }
            case 3 -> {
                System.out.println("Usuario actual: " + estudiante.getUsuarioGym());
                System.out.print("Digite el nuevo usuario: ");
                String usuario = console.nextLine();
                estudiante.setUsuarioGym(usuario);
                System.out.println("Usuario actualizado.");
            }
            case 4 -> {
                System.out.println("Contraseña actual: " + estudiante.getContraseniaGym());
                System.out.print("Digite la nueva contraseña: ");
                String contrasenia = console.nextLine();
                estudiante.setContraseniaGym(contrasenia);
                System.out.println("Contraseña actualizada.");
            }
            case 5 -> {
            // Validación de membresía específica
             boolean membresiaValida = false;
             String membresiaAntigua=estudiante.getMembresia();
             while (!membresiaValida) {

                System.out.println("Membresía actual: " + estudiante.getMembresia());
                System.out.print("Digite la nueva membresía: ");
                membresia = console.nextLine();

                // Convertir la membresía a mayúsculas
                membresia = membresia.toUpperCase();  // Corrected this line

                if (membresia.equals("GRATUITO") || membresia.equals("PREMIUM")) {
                    membresiaValida = true; // Salir del bucle si es válido
                } else {
                    System.out.println("Error: La membresía debe ser 'GRATUITO' o 'PREMIUM'.");
                    }
                }
                    estudiante.setMembresia(membresia);
                    System.out.println("Membresía actualizada.");
                    if(!membresiaAntigua.equals(estudiante.getMembresia())){
                       i=-1; 
                    }
        }

            case 6 -> {
                System.out.println("Saliendo...");
                return;
            }
            default -> System.out.println("Opción inválida.");
        }

        // Reemplazamos el estudiante en la lista según la membresía
        if (membresia.equals("PREMIUM")) {
            estudiantes.set(pos, new EstudiantePremium(estudiante.getNombres(), estudiante.getApellidos(),
                    estudiante.getDni(), estudiante.getEdad(), estudiante.getCodigoEstudiante(),
                    estudiante.getFacultad(), membresia, estudiante.getUsuarioGym(),
                    estudiante.getContraseniaGym()));
            actualizar_Premium(estudiantes);
            
            if(i ==-1){eliminarEstudianteFree(estudiantes,estudiante);}
            
        } else if (membresia.equals("GRATUITO")) {
            estudiantes.set(pos, new EstudianteFree(estudiante.getNombres(), estudiante.getApellidos(),
                    estudiante.getDni(), estudiante.getEdad(), estudiante.getCodigoEstudiante(),
                    estudiante.getFacultad(), membresia, estudiante.getUsuarioGym(),
                    estudiante.getContraseniaGym()));
            
            actualizar_Free(estudiantes);
            if(i ==-1){eliminarEstudiantePremium(estudiantes,estudiante);}
        }
        
        System.out.println("\n\n\tUsuario actualizado.");
        
    }
      
          
       
  public void eliminar_estudiante(ArrayList<Estudiante> estudiantes, int pos) {
    // Validamos si el índice es válido
    if (pos >= 0 && pos < estudiantes.size()) {
        Estudiante estudianteAEliminar = estudiantes.get(pos);

        // Verificar el tipo de membresía y llamar al método adecuado
        if (estudianteAEliminar.getMembresia().equals("PREMIUM")) {
            eliminarEstudiantePremium(estudiantes, estudianteAEliminar);
        } else {
            eliminarEstudianteFree(estudiantes, estudianteAEliminar);
        }
    } else {
        System.out.println("Indice fuera de rango.");
    }
}
  
    public void mostrar_entrenador(Entrenador[] entrenadores) {
        System.out.println("\n\tENTRENADORES SMFIT\n");
        for (Entrenador entrenador : entrenadores) {
            String[][] data = {
                {"Dato", "Informacion"},
                {"Nombre", entrenador.getNombres()},
                {"Apellidos", entrenador.getApellidos()}
            };
            imprimirTabla(data);
        }
    }

  
    public static void imprimirTabla(String[][] data) {
    // Incrementa el tamaño de las columnas para que puedan acomodar más caracteres
    int anchoColumna1 = 30; // Para el nombre
    int anchoColumna2 = 40; // Para el apellido

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

