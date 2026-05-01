import gerador.GeradorRelatorio;
import relatorio.RelatorioArtigo;
import relatorio.RelatorioDieta;
import relatorio.RelatorioFinanceiro;
import visitor.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        RelatorioDieta dieta = new RelatorioDieta(
            "Dieta Mediterrânea",
            "Plano alimentar baseado na dieta mediterrânea para saúde cardiovascular.",
            List.of("Azeite de oliva", "Nozes", "Salmão", "Espinafre", "Tomate", "Alho"),
            1850,
            "Consumir peixes 3x por semana e evitar carnes processadas."
        );

        RelatorioArtigo artigo = new RelatorioArtigo(
            "A Beleza das Montanhas Rochosas",
            "João Silva",
            "As Montanhas Rochosas estendem-se por mais de 4.800 km, atravessando " +
            "vários estados americanos e províncias canadenses. Sua formação geológica " +
            "data de mais de 80 milhões de anos, resultado de intensas forças tectônicas.",
            "https://exemplo.com/montanhas.jpg",
            "Vista panorâmica das Montanhas Rochosas ao amanhecer"
        );

        Map<String, Double> dadosFinanceiros = new LinkedHashMap<>();
        dadosFinanceiros.put("Janeiro",  12500.00);
        dadosFinanceiros.put("Fevereiro", 9800.50);
        dadosFinanceiros.put("Março",    15200.75);
        dadosFinanceiros.put("Abril",    13400.00);

        RelatorioFinanceiro financeiro = new RelatorioFinanceiro(
            "Vendas Q1/Q2 2025",
            "Janeiro-Abril 2025",
            dadosFinanceiros,
            50901.25,
            "Crescimento de 18% em relação ao mesmo período do ano anterior."
        );

        HTMLVisitor     html     = new HTMLVisitor();
        PlanilhaVisitor planilha = new PlanilhaVisitor();
        PDFVisitor      pdf      = new PDFVisitor();
        XMLVisitor      xml      = new XMLVisitor();

        GeradorRelatorio gerador = new GeradorRelatorio();

        printSection("DIETA → PDF");
        System.out.println(gerador.gerar(dieta, pdf));

        printSection("DIETA → PLANILHA (CSV)");
        System.out.println(gerador.gerar(dieta, planilha));

        printSection("ARTIGO → HTML");
        System.out.println(gerador.gerar(artigo, html));

        printSection("ARTIGO → XML");
        System.out.println(gerador.gerar(artigo, xml));

        printSection("FINANCEIRO → PDF");
        System.out.println(gerador.gerar(financeiro, pdf));

        printSection("FINANCEIRO → PLANILHA (CSV)");
        System.out.println(gerador.gerar(financeiro, planilha));

        printSection("FINANCEIRO → XML");
        System.out.println(gerador.gerar(financeiro, xml));

        printSection("RESUMO — TODAS AS COMBINAÇÕES GERADAS COM SUCESSO");
        var relatorios = Map.of(
            "Dieta",      dieta,
            "Artigo",     artigo,
            "Financeiro", financeiro
        );
        var visitors = Map.of(
            "HTML",     (visitor.RelatorioVisitor) html,
            "Planilha", planilha,
            "PDF",      pdf,
            "XML",      xml
        );

        System.out.println();
        System.out.printf("%-15s | %-10s | %-10s%n", "Relatório", "Formato", "Bytes");
        System.out.println("-".repeat(42));
        for (var rel : relatorios.entrySet()) {
            for (var vis : visitors.entrySet()) {
                String output = gerador.gerar(rel.getValue(), vis.getValue());
                System.out.printf("%-15s | %-10s | %6d%n",
                    rel.getKey(), vis.getKey(), output.length());
            }
        }
        System.out.println();
    }

    private static void printSection(String title) {
        System.out.println("\n" + "-".repeat(64));
        System.out.println("  " + title);
        System.out.println("-".repeat(64));
    }
}
