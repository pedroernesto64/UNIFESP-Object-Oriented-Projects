import java.util.List;
import java.util.ArrayList;

public class GerenciadorReservas extends Subject {
  private PoliticaColisao strategy;
  private List<Reserva> reservas = new ArrayList<>();

  private GerenciadorReservas() {}          // proíbe clientes de chamarem new GerenciadorReservas()
  
  private static GerenciadorReservas instance;           // instância única da classe
  
  public static GerenciadorReservas getInstance() {
    if(instance == null)        // primeira vez que se chama getInstance
      instance = new GerenciadorReservas();
    return instance;
  }

  public void setPoliticaStrategy(PoliticaColisao strategy){
    this.strategy = strategy;
  }
  
  public boolean criarReserva(Reserva r) {
    if (strategy != null && !strategy.verificaColisao(r, reservas)) {
      return false; // collision detected
    }
    reservas.add(r);
    notifyObservers(new Property("reserva_criada", r));
    return true;
  }

  public boolean removerReserva(Reserva r) {
    boolean removed = reservas.remove(r);
    if (removed) notifyObservers(new Property("reserva_removida", r));
    return removed;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

  public void getSalasDisponiveis() {
    // placeholder: implementation would consult inventory
    System.out.println("[GerenciadorReservas] Salas disponíveis: (implementação pendente)");
  }
  

}

