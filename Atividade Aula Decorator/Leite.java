public class Leite extends AdicionalDecorator {
    public Leite(Bebida bebida) { this.bebida = bebida; }

    public String getDescricao() {
        return bebida.getDescricao() + ", Leite";
    }

    public double custo() {
        return bebida.custo() + 1.50;
    }
}