import java.util.ArrayList;

class TurnoFree extends Turno {
    private static ArrayList<TurnoFree> turnosFree = new ArrayList<>();

    public TurnoFree(String horario) {
        super(horario, 20); // Máximo 20 estudiantes en TurnoFree
    }

    public static void inicializarTurnos() {
        turnosFree.add(new TurnoFree("8:00 am - 9:00 am"));
        turnosFree.add(new TurnoFree("9:00 am - 10:00 am"));
        turnosFree.add(new TurnoFree("10:00 am - 11:00 am"));
        turnosFree.add(new TurnoFree("11:00 am - 12:00 pm"));
        turnosFree.add(new TurnoFree("2:00 pm - 3:00 pm"));
        turnosFree.add(new TurnoFree("3:00 pm - 4:00 pm"));
        turnosFree.add(new TurnoFree("4:00 pm - 5:00 pm"));
        turnosFree.add(new TurnoFree("5:00 pm - 6:00 pm"));
        turnosFree.add(new TurnoFree("6:00 pm - 7:00 pm"));
        turnosFree.add(new TurnoFree("7:00 pm - 8:00 pm"));
        turnosFree.add(new TurnoFree("8:00 pm - 9:00 pm"));
        turnosFree.add(new TurnoFree("9:00 pm - 10:00 pm"));
    }

    public static void mostrarTurnos() {
        System.out.println("Turnos Free disponibles:");
        for (int i = 0; i < turnosFree.size(); i++) {
            System.out.println((i + 1) + ". " + turnosFree.get(i).getHorario());
        }
    }

    public static TurnoFree seleccionarTurno(int opcion) {
        if (opcion > 0 && opcion <= turnosFree.size()) {
            return turnosFree.get(opcion - 1);
        } else {
            System.out.println("Opción inválida");
            return null;
        }
    }

    @Override
    public boolean reservarCupo(Estudiante estudiante) {
        if (registrarUsuario()) {
            System.out.println("Cupo reservado para " + estudiante.getNombres() + " " + estudiante.getApellidos() + " en el turno " + getHorario());
            return true;
        } else {
            System.out.println("No hay cupos disponibles en el turno " + getHorario());
            return false;
        }
    }
}