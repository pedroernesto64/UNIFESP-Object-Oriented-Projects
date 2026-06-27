package strategy;

public interface EstrategiaDia {
    ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra);
    String nomeDia();
}
