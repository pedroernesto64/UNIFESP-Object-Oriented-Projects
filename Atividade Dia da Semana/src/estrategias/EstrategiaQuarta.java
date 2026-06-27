package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaQuarta implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "quarta-feira";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "Dia de revisão: verifique o andamento da atividade \"%s\".",
                informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.MEDIA);
    }
}
