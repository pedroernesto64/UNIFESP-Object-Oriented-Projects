package strategy;

import java.text.Normalizer;
import java.time.DayOfWeek;
import java.util.Map;
import java.util.Optional;

/**
 * Converte um texto digitado pelo usuário (em português, com ou sem
 * acento, em qualquer caixa) para o DayOfWeek correspondente.
 *
 * Centralizar essa conversão aqui evita repetir lógica de comparação
 * de string em outros pontos do programa. Se o texto não corresponder
 * a nenhum dia conhecido, devolve Optional.empty() em vez de lançar
 * exceção ou devolver null -- assim quem chama já recebe o aviso de
 * "isso pode não existir" embutido no próprio tipo de retorno.
 */
public final class ConversorDia {

    private static final Map<String, DayOfWeek> DIAS_POR_NOME = Map.ofEntries(
            Map.entry("segunda-feira", DayOfWeek.MONDAY),
            Map.entry("segunda", DayOfWeek.MONDAY),
            Map.entry("terca-feira", DayOfWeek.TUESDAY),
            Map.entry("terca", DayOfWeek.TUESDAY),
            Map.entry("quarta-feira", DayOfWeek.WEDNESDAY),
            Map.entry("quarta", DayOfWeek.WEDNESDAY),
            Map.entry("quinta-feira", DayOfWeek.THURSDAY),
            Map.entry("quinta", DayOfWeek.THURSDAY),
            Map.entry("sexta-feira", DayOfWeek.FRIDAY),
            Map.entry("sexta", DayOfWeek.FRIDAY),
            Map.entry("sabado", DayOfWeek.SATURDAY),
            Map.entry("domingo", DayOfWeek.SUNDAY)
    );

    private ConversorDia() {
        // classe utilitária, não deve ser instanciada
    }

    public static Optional<DayOfWeek> converter(String textoDigitado) {
        if (textoDigitado == null) {
            return Optional.empty();
        }
        String chave = normalizar(textoDigitado);
        return Optional.ofNullable(DIAS_POR_NOME.get(chave));
    }

    /**
     * Remove acentos, espaços nas pontas e deixa tudo minúsculo, para
     * que "Quarta-feira", "QUARTA" e "quarta-feira" sejam todos
     * reconhecidos como o mesmo dia.
     */
    private static String normalizar(String texto) {
        String semEspacos = texto.trim().toLowerCase();
        String semAcento = Normalizer.normalize(semEspacos, Normalizer.Form.NFD);
        return semAcento.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}
