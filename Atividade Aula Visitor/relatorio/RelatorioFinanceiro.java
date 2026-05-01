package relatorio;

import visitor.RelatorioVisitor;
import java.util.Map;

public class RelatorioFinanceiro implements Relatorio {

    private final String titulo;
    private final String periodo;
    private final Map<String, Double> dados;
    private final double total;
    private final String analise;

    public RelatorioFinanceiro(String titulo, String periodo,
                               Map<String, Double> dados, double total,
                               String analise) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.dados = Map.copyOf(dados);
        this.total = total;
        this.analise = analise;
    }

    @Override
    public String accept(RelatorioVisitor visitor) {
        return visitor.visit(this);
    }

    @Override public String getTitulo()             { return titulo; }
    public String getPeriodo()                      { return periodo; }
    public Map<String, Double> getDados()           { return dados; }
    public double getTotal()                        { return total; }
    public String getAnalise()                      { return analise; }
}
