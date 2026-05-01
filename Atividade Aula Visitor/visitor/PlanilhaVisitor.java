package visitor;

import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;

import java.util.Map;

public class PlanilhaVisitor implements RelatorioVisitor {

    private static final String SEP = ";";
    private static final String NL  = "\n";

    @Override
    public String visit(RelatorioDieta r) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Dieta").append(NL)
          .append("Título").append(SEP).append(r.getTitulo()).append(NL)
          .append("Descrição").append(SEP).append(r.getDescricao()).append(NL)
          .append("Calorias Totais (kcal)").append(SEP).append(r.getCalorias()).append(NL)
          .append(NL)
          .append("Nº").append(SEP).append("Alimento").append(NL);

        int i = 1;
        for (String alimento : r.getAlimentos()) {
            sb.append(i++).append(SEP).append(alimento).append(NL);
        }

        sb.append(NL)
          .append("Recomendação").append(SEP).append(r.getRecomendacao()).append(NL);

        return sb.toString();
    }

    @Override
    public String visit(RelatorioArtigo r) {
        return "Relatório de Artigo" + NL +
               "Título"    + SEP + r.getTitulo()    + NL +
               "Autor"     + SEP + r.getAutor()     + NL +
               "Imagem"    + SEP + r.getUrlImagem() + NL +
               "Legenda"   + SEP + r.getLegenda()   + NL +
               "Conteúdo"  + SEP + r.getCorpo()     + NL;
    }

    @Override
    public String visit(RelatorioFinanceiro r) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório Financeiro").append(NL)
          .append("Título").append(SEP).append(r.getTitulo()).append(NL)
          .append("Período").append(SEP).append(r.getPeriodo()).append(NL)
          .append(NL)
          .append("Mês").append(SEP).append("Valor (R$)").append(NL);

        for (Map.Entry<String, Double> entry : r.getDados().entrySet()) {
            sb.append(entry.getKey()).append(SEP)
              .append(String.format("%.2f", entry.getValue())).append(NL);
        }

        sb.append("TOTAL").append(SEP).append(String.format("%.2f", r.getTotal())).append(NL)
          .append(NL)
          .append("Análise").append(SEP).append(r.getAnalise()).append(NL);

        return sb.toString();
    }
}
