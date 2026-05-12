import java.util.List;

class PrimeiroAReservarStrategy extends PoliticaColisao {

  @Override
  public boolean verificaColisao(Reserva nova, List<Reserva> existentes) {
    // Simple strategy: allow the first reservation (no collision handling implemented yet)
    return true;
  }

}
