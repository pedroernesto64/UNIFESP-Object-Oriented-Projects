package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaSegunda implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "segunda-feira";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "Bom início de semana, %s! Organize suas prioridades antes de começar a tocar \"%s\".",
                nomeUsuario, informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.ALTA);
    }
}
