package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaQuinta implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "quinta-feira";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "%s, aproveite hoje para colaborar com alguém da equipe sobre \"%s\".",
                nomeUsuario, informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.MEDIA);
    }
}
