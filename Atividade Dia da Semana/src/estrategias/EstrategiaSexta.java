package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaSexta implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "sexta-feira";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "Fechando a semana, %s: registre o que foi concluído em \"%s\".",
                nomeUsuario, informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.MEDIA);
    }
}
