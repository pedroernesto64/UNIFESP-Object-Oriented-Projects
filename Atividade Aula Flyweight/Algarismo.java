public class Algarismo implements InterfaceAlgarismo {
    private int num;

    public Algarismo(int num) {
        this.num = num;
    }

    @Override
    public void imprime() {
        System.out.print(this.num);
    }
}