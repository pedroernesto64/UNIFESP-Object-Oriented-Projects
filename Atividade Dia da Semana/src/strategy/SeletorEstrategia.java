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

    public Optional<EstrategiaDia> obterEstrategia(DayOfWeek dia) {
        return Optional.ofNullable(estrategias.get(dia));
    }

    public Optional<EstrategiaDia> obterEstrategia(String textoDigitado) {
        Optional<DayOfWeek> dia = ConversorDia.converter(textoDigitado);
        return dia.flatMap(this::obterEstrategia);
    }
}
