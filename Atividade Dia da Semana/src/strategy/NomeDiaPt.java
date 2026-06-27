package strategy;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public final class NomeDiaPt {

    private static final Map<DayOfWeek, String> NOMES = new EnumMap<>(DayOfWeek.class);

    static {
        NOMES.put(DayOfWeek.MONDAY, "segunda-feira");
        NOMES.put(DayOfWeek.TUESDAY, "terça-feira");
        NOMES.put(DayOfWeek.WEDNESDAY, "quarta-feira");
        NOMES.put(DayOfWeek.THURSDAY, "quinta-feira");
        NOMES.put(DayOfWeek.FRIDAY, "sexta-feira");
        NOMES.put(DayOfWeek.SATURDAY, "sábado");
        NOMES.put(DayOfWeek.SUNDAY, "domingo");
    }

    private NomeDiaPt() {
    }

    public static String de(DayOfWeek dia) {
        return NOMES.get(dia);
    }
}
