package gerador;

import relatorio.Relatorio;
import visitor.RelatorioVisitor;

public class GeradorRelatorio {

    public String gerar(Relatorio relatorio, RelatorioVisitor visitor) {
        return relatorio.accept(visitor);
    }
}
