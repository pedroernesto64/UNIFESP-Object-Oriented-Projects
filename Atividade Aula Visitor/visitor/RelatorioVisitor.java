package visitor;

import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;

public interface RelatorioVisitor {
    String visit(RelatorioDieta relatorio);
    String visit(RelatorioArtigo relatorio);
    String visit(RelatorioFinanceiro relatorio);
}
