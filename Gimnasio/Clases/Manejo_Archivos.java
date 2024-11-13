import java.io.*;
import java.util.ArrayList;

public interface Manejo_Archivos {
    
    String FREE_FILE_PATH = "C:\\Users\\valer\\OneDrive\\Escritorio\\4TO CICLO\\JAVA EN vs\\NEATBEANS\\Neatbeans\\src\\main\\resources\\com\\mycompany\\Gimnasio\\EstudianteFree.txt";

    String PREMIUM_FILE_PATH = "C:\\Users\\valer\\OneDrive\\Escritorio\\4TO CICLO\\JAVA EN vs\\NEATBEANS\\Neatbeans\\src\\main\\resources\\com\\mycompany\\Gimnasio\\EstudiantesPremium.txt";
    

default void cargarEstudiantesFree(ArrayList<Estudiante> estudiantes) {
    File file = new File(FREE_FILE_PATH);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "GRATUITO", datos[7], datos[8]
                    );
                    estudiantes.add(estudiante);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Free desde el archivo: " + e.getMessage());
        }
    } else {
        System.out.println("Archivo no encontrado en: " + FREE_FILE_PATH);
    }
}


    // Agregar estudiantes Free asegurando no duplicar
    default void agregar_estudianteFree(ArrayList<Estudiante> estudiantes) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FREE_FILE_PATH, true))) {  // true para no sobrescribir
        for (Estudiante estudiante : estudiantes) {
            if (estudiante instanceof EstudianteFree) {
                EstudianteFree est = (EstudianteFree) estudiante;
                // Escribir los datos solo si no existen ya en el archivo
                if (!existeEstudiante(est)) {  // Método para verificar si ya existe
                    writer.write(est.getNombres() + "," + est.getApellidos() + "," + est.getDni() + ","
                            + est.getEdad() + "," + est.getCodigoEstudiante() + "," + est.getFacultad() + ","
                            + est.getMembresia() + "," + est.getUsuarioGym() + "," + est.getContraseniaGym());
                }
            }
        }
        System.out.println("Estudiantes Free agregados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al agregar estudiantes Free: " + e.getMessage());
        }
    }


    // Verificar si el estudiante ya existe (basado en DNI o algún campo único)
    private boolean existeEstudiante(EstudianteFree est) {
    // Leer el archivo y verificar si el estudiante ya existe
    File file = new File(FREE_FILE_PATH);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9 && datos[2].equals(String.valueOf(est.getDni()))) {  // Comparar por DNI
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al verificar existencia de estudiante: " + e.getMessage());
        }
    }
        return false;
    }
    
    
    
    default void actualizar_Free(ArrayList<Estudiante> estudiantes) {
    ArrayList<Estudiante> estudiantesActuales = new ArrayList<>();
    File file = new File(FREE_FILE_PATH);

    // Si el archivo existe, leemos los estudiantes existentes
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    // Creamos un nuevo estudiante desde el archivo
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "GRATUITO", datos[7], datos[8]
                    );
                    estudiantesActuales.add(estudiante);  // Añadir estudiante actual
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Free: " + e.getMessage());
        }
    }

    // Actualizamos los estudiantes
    for (Estudiante estudiante : estudiantes) {
         if (estudiante instanceof EstudianteFree) {
        boolean actualizado = false;

        // Actualizar estudiante si ya existe en la lista
        for (int i = 0; i < estudiantesActuales.size(); i++) {
            Estudiante actual = estudiantesActuales.get(i);
            if (actual.getDni() == estudiante.getDni()) { // Suponiendo que el DNI es único
                estudiantesActuales.set(i, estudiante);  // Reemplazar estudiante existente
                actualizado = true;
                break;
            }
        }
        
        // Si el estudiante no fue actualizado, lo añadimos a la lista
        if (!actualizado) {
            estudiantesActuales.add(estudiante);
            }
        }
    }

    // Reemplazar el archivo con los estudiantes actualizados
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FREE_FILE_PATH))) {
        for (Estudiante estudiante : estudiantesActuales) {
            writer.write(estudiante.getNombres() + "," + estudiante.getApellidos() + "," + estudiante.getDni() + ","
                    + estudiante.getEdad() + "," + estudiante.getCodigoEstudiante() + "," + estudiante.getFacultad() + ","
                    + estudiante.getMembresia() + "," + estudiante.getUsuarioGym() + "," + estudiante.getContraseniaGym());
            writer.newLine();
        }
        System.out.println("Archivo Free actualizado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al actualizar el archivo Free: " + e.getMessage());
        }
    }


    
    default void eliminarEstudianteFree(ArrayList<Estudiante> estudiantes, Estudiante estudianteAEliminar) {
    ArrayList<Estudiante> estudiantesActuales = new ArrayList<>();
    File file = new File(FREE_FILE_PATH);

    // Si el archivo existe, leemos los estudiantes existentes
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    // Creamos un nuevo estudiante desde el archivo
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "GRATUITO", datos[7], datos[8]
                    );
                    estudiantesActuales.add(estudiante);  // Añadir estudiante actual
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Free: " + e.getMessage());
        }
    }
    // Eliminar el estudiante a eliminar (por DNI) del array de estudiantes
    estudiantes.removeIf(est -> est.getDni() == estudianteAEliminar.getDni());
    // Eliminar el estudiante a eliminar (por DNI)
    estudiantesActuales.removeIf(est -> est.getDni() == estudianteAEliminar.getDni());

    // Reemplazar el archivo con los estudiantes actualizados
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FREE_FILE_PATH))) {
        for (Estudiante estudiante : estudiantesActuales) {
            writer.write(estudiante.getNombres() + "," + estudiante.getApellidos() + "," + estudiante.getDni() + ","
                    + estudiante.getEdad() + "," + estudiante.getCodigoEstudiante() + "," + estudiante.getFacultad() + ","
                    + estudiante.getMembresia() + "," + estudiante.getUsuarioGym() + "," + estudiante.getContraseniaGym());
            writer.newLine();
        }
        System.out.println("Estudiantes Free eliminados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al actualizar el archivo Free después de eliminar estudiantes: " + e.getMessage());
    }
}

   
    
//------------------------------------------------------------------------------------------------
   
    
    
   
 // Cargar estudiantes Premium desde el archivo
    default void cargarEstudiantesPremium(ArrayList<Estudiante> estudiantes) {
    File file = new File(PREMIUM_FILE_PATH);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "PREMIUM", datos[7], datos[8]
                    );
                    estudiantes.add(estudiante);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Premium desde el archivo: " + e.getMessage());
        }
    } else {
        System.out.println("Archivo no encontrado en: " + PREMIUM_FILE_PATH);
        }
    }

    // Agregar estudiantes Premium asegurando no duplicar
    default void agregar_estudiantePremium(ArrayList<Estudiante> estudiantes) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PREMIUM_FILE_PATH, true))) {  // true para no sobrescribir
        for (Estudiante estudiante : estudiantes) {
            if (estudiante instanceof EstudiantePremium) {
                EstudiantePremium est = (EstudiantePremium) estudiante;
                // Escribir los datos solo si no existen ya en el archivo
                if (!existeEstudiantePremium(est)) {  // Método para verificar si ya existe
                    writer.write(est.getNombres() + "," + est.getApellidos() + "," + est.getDni() + ","
                            + est.getEdad() + "," + est.getCodigoEstudiante() + "," + est.getFacultad() + ","
                            + est.getMembresia() + "," + est.getUsuarioGym() + "," + est.getContraseniaGym());
                }
            }
        }
        System.out.println("Estudiantes Premium agregados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al agregar estudiantes Premium: " + e.getMessage());
        }
    }

    // Verificar si el estudiante Premium ya existe (basado en DNI o algún campo único)
    private boolean existeEstudiantePremium(EstudiantePremium est) {
    // Leer el archivo y verificar si el estudiante ya existe
    File file = new File(PREMIUM_FILE_PATH);
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9 && datos[2].equals(String.valueOf(est.getDni()))) {  // Comparar por DNI
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al verificar existencia de estudiante Premium: " + e.getMessage());
        }
        }
        return false;
    }

    // Actualizar el archivo Premium sin sobrescribir todo
    default void actualizar_Premium(ArrayList<Estudiante> estudiantes) {
    ArrayList<Estudiante> estudiantesActuales = new ArrayList<>();
    File file = new File(PREMIUM_FILE_PATH);  // Usar el archivo específico para PREMIUM

    // Si el archivo existe, leemos los estudiantes existentes
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    // Creamos un nuevo estudiante desde el archivo
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "PREMIUM", datos[7], datos[8]  // Aquí marcamos que es PREMIUM
                    );
                    estudiantesActuales.add(estudiante);  // Añadir estudiante actual
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Premium: " + e.getMessage());
        }
    }

    // Actualizamos los estudiantes
    for (Estudiante estudiante : estudiantes) {
        if (estudiante instanceof EstudiantePremium) {  // Solo actualizamos los estudiantes PREMIUM
            boolean actualizado = false;

            // Actualizar estudiante si ya existe en la lista
            for (int i = 0; i < estudiantesActuales.size(); i++) {
                Estudiante actual = estudiantesActuales.get(i);
                if (actual.getDni() == estudiante.getDni()) {  // Suponiendo que el DNI es único
                    estudiantesActuales.set(i, estudiante);  // Reemplazar estudiante existente
                    actualizado = true;
                    break;
                }
            }

            // Si el estudiante no fue actualizado, lo añadimos a la lista
            if (!actualizado) {
                estudiantesActuales.add(estudiante);
            }
        }
    }

    // Reemplazar el archivo con los estudiantes actualizados
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PREMIUM_FILE_PATH))) {  // Usar el archivo específico para PREMIUM
        for (Estudiante estudiante : estudiantesActuales) {
            writer.write(estudiante.getNombres() + "," + estudiante.getApellidos() + "," + estudiante.getDni() + ","
                    + estudiante.getEdad() + "," + estudiante.getCodigoEstudiante() + "," + estudiante.getFacultad() + ","
                    + estudiante.getMembresia() + "," + estudiante.getUsuarioGym() + "," + estudiante.getContraseniaGym());
            writer.newLine();
        }
        System.out.println("Archivo Premium actualizado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al actualizar el archivo Premium: " + e.getMessage());
        }
    }
    
    
    
   default void eliminarEstudiantePremium(ArrayList<Estudiante> estudiantes, Estudiante estudianteAEliminar) {
    ArrayList<Estudiante> estudiantesActuales = new ArrayList<>();
    File file = new File(PREMIUM_FILE_PATH);  // Ruta del archivo de estudiantes PREMIUM

    // Si el archivo existe, leemos los estudiantes existentes
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 9) {
                    // Creamos un nuevo estudiante desde el archivo
                    Estudiante estudiante = new Estudiante(
                        datos[0], datos[1], Long.parseLong(datos[2]), Integer.parseInt(datos[3]),
                        datos[4], datos[5], "PREMIUM", datos[7], datos[8]
                    );
                    estudiantesActuales.add(estudiante);  // Añadir estudiante actual
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los estudiantes Premium: " + e.getMessage());
        }
    }
    // Eliminar el estudiante a eliminar (por DNI) del array de estudiantes
    estudiantes.removeIf(est -> est.getDni() == estudianteAEliminar.getDni());
    
    // Eliminar el estudiante a eliminar (por DNI)
    estudiantesActuales.removeIf(est -> est.getDni() == estudianteAEliminar.getDni());

    // Reemplazar el archivo con los estudiantes actualizados
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PREMIUM_FILE_PATH))) {
        for (Estudiante estudiante : estudiantesActuales) {
            writer.write(estudiante.getNombres() + "," + estudiante.getApellidos() + "," + estudiante.getDni() + ","
                    + estudiante.getEdad() + "," + estudiante.getCodigoEstudiante() + "," + estudiante.getFacultad() + ","
                    + estudiante.getMembresia() + "," + estudiante.getUsuarioGym() + "," + estudiante.getContraseniaGym());
            writer.newLine();
        }
        System.out.println("Estudiantes Premium eliminados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al actualizar el archivo Premium después de eliminar estudiantes: " + e.getMessage());
        }
    }
   
}