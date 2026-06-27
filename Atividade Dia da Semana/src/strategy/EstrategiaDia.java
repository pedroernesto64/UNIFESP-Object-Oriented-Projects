package strategy;

/**
 * Contrato que toda estratégia de comportamento por dia precisa seguir.
 *
 * Cada dia da semana terá sua própria implementação dessa interface,
 * sabendo gerar a mensagem e a prioridade adequadas para aquele dia.
 * Quem usa a estratégia (o Main, no nosso caso) não precisa saber qual
 * dia está por trás dela -- só chama executar() e recebe a resposta.
 */
public interface EstrategiaDia {

    /**
     * Executa o comportamento do dia, usando os dados informados pelo
     * usuário (nome e uma informação extra, como tarefa ou meta).
     */
    ResultadoEstrategia executar(String nomeUsuario, String informacaoExtra);

    /**
     * Nome do dia que essa estratégia representa, usado só para exibição.
     */
    String nomeDia();
}
