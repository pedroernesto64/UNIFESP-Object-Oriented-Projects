package visitor;

import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;

import java.util.Map;

public class PDFVisitor implements RelatorioVisitor {

    private static final String LINE  = "-".repeat(60);
    private static final String DLINE = "=".repeat(60);

    @Override
    public String visit(RelatorioDieta r) {
        StringBuilder sb = new StringBuilder();
        sb.append(DLINE).append("\n")
          .append(center("RELATÓRIO DE DIETA ALIMENTAR ESPECIAL")).append("\n")
          .append(DLINE).append("\n\n")
          .append("TÍTULO   : ").append(r.getTitulo()).append("\n")
          .append("DESCRIÇÃO: ").append(r.getDescricao()).append("\n\n")
          .append(LINE).append("\n")
          .append("  ALIMENTOS\n")
          .append(LINE).append("\n");

        int i = 1;
        for (String alimento : r.getAlimentos()) {
            sb.append(String.format("  %2d. %s%n", i++, alimento));
        }

        sb.append("\n")
          .append(String.format("  Calorias totais: %d kcal%n%n", r.getCalorias()))
          .append(LINE).append("\n")
          .append("  RECOMENDAÇÃO\n")
          .append(LINE).append("\n")
          .append("  ").append(r.getRecomendacao()).append("\n\n")
          .append(DLINE).append("\n");

        return sb.toString();
    }

    @Override
    public String visit(RelatorioArtigo r) {
        return DLINE + "\n" +
               center(r.getTitulo().toUpperCase()) + "\n" +
               DLINE + "\n\n" +
               "Autor : " + r.getAutor() + "\n" +
               "Imagem: " + r.getUrlImagem() + "\n" +
               "        " + r.getLegenda() + "\n\n" +
               LINE + "\n" +
               wordWrap(r.getCorpo(), 58) + "\n" +
               LINE + "\n";
    }

    @Override
    public String visit(RelatorioFinanceiro r) {
        StringBuilder sb = new StringBuilder();
        sb.append(DLINE).append("\n")
          .append(center("RELATÓRIO FINANCEIRO")).append("\n")
          .append(DLINE).append("\n\n")
          .append("TÍTULO  : ").append(r.getTitulo()).append("\n")
          .append("PERÍODO : ").append(r.getPeriodo()).append("\n\n")
          .append(String.format("  %-20s %15s%n", "MÊS", "VALOR (R$)"))
          .append(LINE).append("\n");

        for (Map.Entry<String, Double> entry : r.getDados().entrySet()) {
            sb.append(String.format("  %-20s %15.2f%n", entry.getKey(), entry.getValue()));
        }

        sb.append(LINE).append("\n")
          .append(String.format("  %-20s %15.2f%n%n", "TOTAL", r.getTotal()))
          .append("ANÁLISE:\n  ").append(r.getAnalise()).append("\n\n")
          .append(DLINE).append("\n");

        return sb.toString();
    }

    private static String center(String text) {
        int padding = Math.max(0, (60 - text.length()) / 2);
        return " ".repeat(padding) + text;
    }

    private static String wordWrap(String text, int width) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split("\\s+");
        int col = 0;
        for (String word : words) {
            if (col + word.length() + 1 > width) {
                sb.append("\n");
                col = 0;
            }
            sb.append(word).append(" ");
            col += word.length() + 1;
        }
        return sb.toString().trim();
    }
}
