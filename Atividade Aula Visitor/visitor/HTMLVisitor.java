package visitor;

import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;

import java.util.Map;

public class HTMLVisitor implements RelatorioVisitor {

    @Override
    public String visit(RelatorioDieta r) {
        StringBuilder sb = new StringBuilder();
        sb.append("[HTML] Relatório de Dieta\n")
          .append("Título: ").append(r.getTitulo()).append("\n")
          .append("Descrição: ").append(r.getDescricao()).append("\n")
          .append("Alimentos: ").append(r.getAlimentos()).append("\n")
          .append("Calorias: ").append(r.getCalorias()).append(" kcal\n")
          .append("Recomendação: ").append(r.getRecomendacao());
        return sb.toString();
    }

    @Override
    public String visit(RelatorioArtigo r) {
        StringBuilder sb = new StringBuilder();
        sb.append("[HTML] Relatório de Artigo\n")
          .append("Título: ").append(r.getTitulo()).append("\n")
          .append("Autor: ").append(r.getAutor()).append("\n")
          .append("Imagem: ").append(r.getUrlImagem()).append("\n")
          .append("Legenda: ").append(r.getLegenda()).append("\n")
          .append("Conteúdo: ").append(r.getCorpo());
        return sb.toString();
    }

    @Override
    public String visit(RelatorioFinanceiro r) {
        StringBuilder sb = new StringBuilder();
        sb.append("[HTML] Relatório Financeiro\n")
          .append("Título: ").append(r.getTitulo()).append("\n")
          .append("Período: ").append(r.getPeriodo()).append("\n");
        for (Map.Entry<String, Double> entry : r.getDados().entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": R$ ")
              .append(String.format("%.2f", entry.getValue())).append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", r.getTotal())).append("\n")
          .append("Análise: ").append(r.getAnalise());
        return sb.toString();
    }
}
