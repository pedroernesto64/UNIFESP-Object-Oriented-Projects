package strategy;

import estrategias.EstrategiaDomingo;
import estrategias.EstrategiaQuarta;
import estrategias.EstrategiaQuinta;
import estrategias.EstrategiaSabado;
import estrategias.EstrategiaSegunda;
import estrategias.EstrategiaSexta;
import estrategias.EstrategiaTerca;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

/**
 * Componente responsável por escolher a estratégia correta para um
 * dia da semana.
 *
 * Guardamos as estratégias em um Map<DayOfWeek, EstrategiaDia>, então
 * encontrar a estratégia certa é só uma busca no mapa -- nada de
 * if/else comparando dia por dia.
 *
 * Como a disciplina ainda não trabalhou o Null Object Pattern, em vez
 * de devolver um objeto "vazio" para representar a ausência de
 * estratégia, devolvemos um Optional<EstrategiaDia>. O Optional já é
 * suficiente para avisar "pode não ter estratégia aqui" sem que o
 * código principal precise espalhar checagens de null por todo lado:
 * o tratamento da ausência fica concentrado em um único lugar, no
 * momento em que o Optional é consumido (veja Main.java).
 */
public class SeletorEstrategia {

    private final Map<DayOfWeek, EstrategiaDia> estrategias;

    public SeletorEstrategia() {
        this.estrategias = new EnumMap<>(DayOfWeek.class);
        estrategias.put(DayOfWeek.MONDAY, new EstrategiaSegunda());
        estrategias.put(DayOfWeek.TUESDAY, new EstrategiaTerca());
        estrategias.put(DayOfWeek.WEDNESDAY, new EstrategiaQuarta());
        estrategias.put(DayOfWeek.THURSDAY, new EstrategiaQuinta());
        estrategias.put(DayOfWeek.FRIDAY, new EstrategiaSexta());
        estrategias.put(DayOfWeek.SATURDAY, new EstrategiaSabado());
        estrategias.put(DayOfWeek.SUNDAY, new EstrategiaDomingo());
    }

    /**
     * Busca a estratégia associada a um DayOfWeek já reconhecido.
     * Devolve Optional.empty() se, por algum motivo, não houver
     * estratégia cadastrada para esse dia (não deveria acontecer com
     * os 7 dias da semana, mas deixamos o método seguro mesmo assim).
     */
    public Optional<EstrategiaDia> obterEstrategia(DayOfWeek dia) {
        return Optional.ofNullable(estrategias.get(dia));
    }

    /**
     * Busca a estratégia a partir de um texto digitado pelo usuário
     * (ex: "quarta-feira", "QUARTA", "sabado"). Se o texto não
     * corresponder a nenhum dia válido, devolve Optional.empty() --
     * é o mesmo caminho seguro usado quando o dia existe mas não tem
     * estratégia associada.
     */
    public Optional<EstrategiaDia> obterEstrategia(String textoDigitado) {
        Optional<DayOfWeek> dia = ConversorDia.converter(textoDigitado);
        return dia.flatMap(this::obterEstrategia);
    }
}
