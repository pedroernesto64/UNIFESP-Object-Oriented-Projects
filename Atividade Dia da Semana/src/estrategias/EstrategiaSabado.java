package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaSabado implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "sábado";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "Hoje o ritmo é outro, %s. Aproveite para estudar algo livre ou simplesmente descansar.",
                nomeUsuario
        );
        return new ResultadoEstrategia(mensagem, Prioridade.BAIXA);
    }
}
