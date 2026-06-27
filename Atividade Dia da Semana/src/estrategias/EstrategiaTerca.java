package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaTerca implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "terça-feira";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "%s, hoje é dia de avançar nas tarefas pendentes. Dê atenção especial a \"%s\".",
                nomeUsuario, informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.ALTA);
    }
}
