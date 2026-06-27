package strategy;

/**
 * Empacota o resultado de uma estratégia: a mensagem principal e a
 * recomendação de prioridade (ALTA, MEDIA ou BAIXA) para o dia.
 *
 * Usamos um record porque isso aqui é só um carregador de dados
 * imutável, sem nenhum comportamento próprio.
 */
public record ResultadoEstrategia(String mensagem, Prioridade prioridade) {
}
