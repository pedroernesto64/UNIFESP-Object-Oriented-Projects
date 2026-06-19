import java.util.Comparator;

public class MedePalavrasTamanho implements Comparator<String> {
    @Override
    public int compare(String p1, String p2) {
        Integer t1 = p1.length();
        Integer t2 = p2.length();

        if (t1 > t2) return 1;
        if (t1 < t2) return -1;
        return 0;
    }
}
