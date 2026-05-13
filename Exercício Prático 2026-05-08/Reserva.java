import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private static int nextId = 1;
    private final int id;
    private final Usuario usuario;
    private final Sala sala;
    private final LocalDate data;
    private final LocalTime horarioInicio;
    private final LocalTime horarioTermino;
    

    public Reserva(Usuario usuario, Sala sala, LocalDate data, LocalTime horarioInicio, LocalTime horarioTermino) {
        if (fim.isBefore(inicio) || fim.isEqual(inicio)) {
        throw new IllegalArgumentException("Erro: O horário de término deve ser após o horário de início.");
    }
        this.id = nextId++;
        this.usuario = usuario;
        this.sala = sala;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Sala getSala() { return sala; }
    public LocalDate getData() { return data; }
    public LocalTime getInicio() { return horarioInicio; }
    public LocalTime getTermino() { return horarioTermino; }

    public boolean temConflito(Reserva outra) {
        if (!this.data.equals(outra.getData())) return false;
        return (this.horarioInicio.isBefore(outra.getTermino()) && 
                this.horarioTermino.isAfter(outra.getInicio()));
    }

    @Override
    public String toString() {
        return String.format("Reserva [%s] - Data: %s | %s às %s | Sala: %d | Usuário: %s", 
            this.id, this.data, this.horarioInicio, this.horarioTermino, this.sala.getNumero(), this.usuario.getNome());
    }
}
