public class Reserva {
    private static int nextId = 1;
    private final int id;
    private final Usuario usuario;
    private final Sala sala;
    private final String horario;

    public Reserva(Usuario usuario, Sala sala, String horario) {
        this.id = nextId++;
        this.usuario = usuario;
        this.sala = sala;
        this.horario = horario;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Sala getSala() { return sala; }
    public String getHorario() { return horario; }

    public String toString() {
        return "Reserva#" + id + "(" + usuario + ", " + sala.getClass().getSimpleName() + ", " + horario + ")";
    }
}
