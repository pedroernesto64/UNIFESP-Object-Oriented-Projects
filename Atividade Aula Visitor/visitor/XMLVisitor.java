package visitor;

import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;

import java.util.Map;

public class XMLVisitor implements RelatorioVisitor {

    @Override
    public String visit(RelatorioDieta r) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
          .append("<relatorioDieta>\n")
          .append("  <titulo>").append(escape(r.getTitulo())).append("</titulo>\n")
          .append("  <descricao>").append(escape(r.getDescricao())).append("</descricao>\n")
          .append("  <calorias>").append(r.getCalorias()).append("</calorias>\n")
          .append("  <alimentos>\n");

        for (String alimento : r.getAlimentos()) {
            sb.append("    <alimento>").append(escape(alimento)).append("</alimento>\n");
        }

        sb.append("  </alimentos>\n")
          .append("  <recomendacao>").append(escape(r.getRecomendacao())).append("</recomendacao>\n")
          .append("</relatorioDieta>");

        return sb.toString();
    }

    @Override
    public String visit(RelatorioArtigo r) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
               "<relatorioArtigo>\n" +
               "  <titulo>"    + escape(r.getTitulo())    + "</titulo>\n" +
               "  <autor>"     + escape(r.getAutor())     + "</autor>\n" +
               "  <urlImagem>" + escape(r.getUrlImagem()) + "</urlImagem>\n" +
               "  <legenda>"   + escape(r.getLegenda())   + "</legenda>\n" +
               "  <corpo>"     + escape(r.getCorpo())     + "</corpo>\n" +
               "</relatorioArtigo>";
    }

    @Override
    public String visit(RelatorioFinanceiro r) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
          .append("<relatorioFinanceiro>\n")
          .append("  <titulo>").append(escape(r.getTitulo())).append("</titulo>\n")
          .append("  <periodo>").append(escape(r.getPeriodo())).append("</periodo>\n")
          .append("  <dados>\n");

        for (Map.Entry<String, Double> entry : r.getDados().entrySet()) {
            sb.append("    <entrada mes=\"").append(escape(entry.getKey())).append("\">")
              .append(String.format("%.2f", entry.getValue()))
              .append("</entrada>\n");
        }

        sb.append("  </dados>\n")
          .append("  <total>").append(String.format("%.2f", r.getTotal())).append("</total>\n")
          .append("  <analise>").append(escape(r.getAnalise())).append("</analise>\n")
          .append("</relatorioFinanceiro>");

        return sb.toString();
    }

    private static String escape(String text) {
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;");
    }
}
