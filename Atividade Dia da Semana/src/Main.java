import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;
import strategy.SeletorEstrategia;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeletorEstrategia seletor = new SeletorEstrategia();

        System.out.println("=== Comportamento por Dia da Semana ===");

        System.out.print("Digite seu nome: ");
        String nomeUsuario = lerOuPadrao(scanner, "Usuário");

        System.out.print("Digite uma informação adicional (tarefa, meta semanal etc.): ");
        String informacaoExtra = lerOuPadrao(scanner, "minhas tarefas");

        System.out.println();
        System.out.println("Deseja consultar o dia de hoje ou informar outro dia manualmente?");
        System.out.println("1 - Usar o dia atual");
        System.out.println("2 - Informar outro dia");
        System.out.print("Escolha (1 ou 2): ");
        String opcao = scanner.nextLine().trim();

        Optional<EstrategiaDia> estrategiaEncontrada;
        String diaConsultadoTexto;

        if (opcao.equals("2")) {
            System.out.print("Digite o dia (ex: segunda-feira, terca-feira, sabado...): ");
            diaConsultadoTexto = scanner.nextLine().trim();
            estrategiaEncontrada = seletor.obterEstrategia(diaConsultadoTexto);
        } else {
            DayOfWeek hoje = LocalDate.now().getDayOfWeek();
            diaConsultadoTexto = strategy.NomeDiaPt.de(hoje);
            estrategiaEncontrada = seletor.obterEstrategia(hoje);
        }

        ResultadoEstrategia resultado = estrategiaEncontrada
                .map(estrategia -> estrategia.executar(nomeUsuario, informacaoExtra))
                .orElseGet(() -> new ResultadoEstrategia(
                        String.format(
                                "Não existe estratégia definida para \"%s\". Nenhuma ação será executada.",
                                diaConsultadoTexto
                        ),
                        Prioridade.BAIXA
                ));

        String nomeDiaExibido = estrategiaEncontrada
                .map(EstrategiaDia::nomeDia)
                .orElse(diaConsultadoTexto);

        exibirResultado(nomeUsuario, nomeDiaExibido, resultado);
    }

    private static String lerOuPadrao(Scanner scanner, String valorPadrao) {
        String entrada = scanner.nextLine().trim();
        return entrada.isEmpty() ? valorPadrao : entrada;
    }

    private static void exibirResultado(String usuario, String diaConsultado, ResultadoEstrategia resultado) {
        System.out.println();
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: " + diaConsultado);
        System.out.println("Prioridade: " + resultado.prioridade());
        System.out.println("Mensagem: " + resultado.mensagem());
    }
}
