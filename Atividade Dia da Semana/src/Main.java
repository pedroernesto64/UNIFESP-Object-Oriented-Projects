import strategy.EstrategiaDia;
import strategy.Prioridade;
import strategy.ResultadoEstrategia;
import strategy.SeletorEstrategia;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

/**
 * Programa principal.
 *
 * Fluxo:
 * 1. Pega a data atual do sistema e descobre o dia da semana.
 * 2. Pergunta o nome do usuário e uma informação extra (tarefa, meta...).
 * 3. Pergunta se o usuário quer consultar o dia atual ou outro dia
 *    qualquer, digitado manualmente.
 * 4. Usa o SeletorEstrategia para achar a estratégia certa e executa ela.
 *
 * Repare que esse arquivo não tem nenhum "if (dia.equals("segunda-feira"))"
 * ou parecido -- toda a decisão de qual mensagem/prioridade usar fica
 * dentro das classes de estratégia. Aqui só orquestramos o fluxo e
 * tratamos, em um único lugar, o caso em que não existe estratégia
 * para o dia pedido.
 */
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

        // Esse é o único ponto do programa que trata a ausência de
        // estratégia. Em vez de checar "if (estrategia != null)" depois
        // de cada busca, deixamos o Optional encapsular essa
        // possibilidade e resolvemos os dois caminhos (achou / não
        // achou) aqui, de uma vez só, com map/orElseGet.
        ResultadoEstrategia resultado = estrategiaEncontrada
                .map(estrategia -> estrategia.executar(nomeUsuario, informacaoExtra))
                .orElseGet(() -> new ResultadoEstrategia(
                        String.format(
                                "Não existe estratégia definida para \"%s\". Nenhuma ação será executada.",
                                diaConsultadoTexto
                        ),
                        Prioridade.BAIXA
                ));

        // Quando a estratégia foi encontrada, mostramos o nome canônico
        // do dia (ex: "terça-feira"), não o texto exatamente como foi
        // digitado -- assim "TERÇA-FEIRA" ou "terca" aparecem sempre
        // da mesma forma na saída.
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
