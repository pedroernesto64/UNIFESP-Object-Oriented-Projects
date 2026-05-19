import java.util.HashMap;
import java.util.Map;

public class FactoryAlgarismo {
    private static final Map<Integer, InterfaceAlgarismo> algarismoMap = new HashMap<>();

    public static InterfaceAlgarismo getAlgarismo(int num) {
        InterfaceAlgarismo alg = algarismoMap.get(num);

        if (alg == null) {
            alg = new Algarismo(num);
            algarismoMap.put(num, alg);
            alg.imprime();
        }
    }
}
