package relatorio;

import visitor.RelatorioVisitor;
import java.util.List;

public class RelatorioDieta implements Relatorio {

    private final String titulo;
    private final String descricao;
    private final List<String> alimentos;
    private final int calorias;
    private final String recomendacao;

    public RelatorioDieta(String titulo, String descricao,
                          List<String> alimentos, int calorias,
                          String recomendacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.alimentos = List.copyOf(alimentos);
        this.calorias = calorias;
        this.recomendacao = recomendacao;
    }

    @Override
    public String accept(RelatorioVisitor visitor) {
        return visitor.visit(this);
    }

    @Override public String getTitulo()       { return titulo; }
    public String getDescricao()              { return descricao; }
    public List<String> getAlimentos()        { return alimentos; }
    public int getCalorias()                  { return calorias; }
    public String getRecomendacao()           { return recomendacao; }
}
