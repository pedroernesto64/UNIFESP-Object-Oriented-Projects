package estrategias;

import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;

public class EstrategiaDomingo implements EstrategiaDia {

    @Override
    public String nomeDia() {
        return "domingo";
    }

    @Override
    public ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra) {
        String mensagem = String.format(
                "%s, use o domingo para planejar a próxima semana e organizar \"%s\" com calma.",
                nomeUsuario, informacaoExtra
        );
        return new ResultadoEstrategia(mensagem, Prioridade.BAIXA);
    }
}
