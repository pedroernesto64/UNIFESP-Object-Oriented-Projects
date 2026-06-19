import java.util.Arrays;

public class Main {
    public Main() {
        String palavras[] = {"Ana", "Bruno", "Carlos", "Distióclenes", "Diana", "Eduardo", "Pilchowski", "Fernanda", "Gabriel", "Helena", "Igor", "Julia"};
        Arrays.sort(palavras, new MedePalavrasAlfabetico());
        for (int i=0; i<palavras.length; i++) {
            System.out.println(palavras[i]);
        }
        System.out.println("==============================");
        Arrays.sort(palavras, new MedePalavrasTamanho());
        for (int i=0; i<palavras.length; i++) {
            System.out.println(palavras[i]);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
