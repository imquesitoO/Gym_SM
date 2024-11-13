import java.util.ArrayList;

class TurnoPremium extends Turno {
    private static ArrayList<TurnoPremium> turnosPremium = new ArrayList<>();

    public TurnoPremium(String horario) {
        super(horario, 10); // Máximo 10 estudiantes en TurnoPremium
    }

    public static void inicializarTurnos() {
        turnosPremium.add(new TurnoPremium("8:00 am - 10:00 am"));
        turnosPremium.add(new TurnoPremium("10:00 am - 12:00 pm"));
        turnosPremium.add(new TurnoPremium("2:00 pm - 4:00 pm"));
        turnosPremium.add(new TurnoPremium("4:00 pm - 6:00 pm"));
        turnosPremium.add(new TurnoPremium("6:00 pm - 8:00 pm"));
        turnosPremium.add(new TurnoPremium("8:00 pm - 10:00 pm"));
    }

    public static void mostrarTurnos() {
        System.out.println("Turnos Premium disponibles:");
        for (int i = 0; i < turnosPremium.size(); i++) {
            System.out.println((i + 1) + ". " + turnosPremium.get(i).getHorario());
        }
    }

    public static TurnoPremium seleccionarTurno(int opcion) {
        if (opcion > 0 && opcion <= turnosPremium.size()) {
            return turnosPremium.get(opcion - 1);
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