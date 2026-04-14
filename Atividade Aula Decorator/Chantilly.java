public class Chantilly extends AdicionalDecorator {
    public Chantilly(Bebida bebida) { this.bebida = bebida; }

    public String getDescricao() {
        return bebida.getDescricao() + ", Chantilly";
    }

    public double custo() {
        return bebida.custo() + 2.00;
    }
}