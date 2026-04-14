public class Main {
    public static void main(String[] args) {
        // Cliente pede um Café Expresso com Leite e Chantilly
        Bebida meuCafe = new CafeExpresso();
        meuCafe = new Leite(meuCafe);
        meuCafe = new Chantilly(meuCafe);

        System.out.println("Pedido: " + meuCafe.getDescricao());
        System.out.println("Total: R$ " + meuCafe.custo());
    }
}