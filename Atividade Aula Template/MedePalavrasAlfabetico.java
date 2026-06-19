import java.util.Comparator;

public class MedePalavrasAlfabetico implements Comparator<String> {
    @Override
    public int compare(String p1, String p2) {
        Character l1 = p1.substring(p1.length() - 1).charAt(0);
        Character l2 = p2.substring(p2.length() - 1).charAt(0);

        if (l1 > l2) return 1;
        if (l1 < l2) return -1;
        return 0;
    }
}
