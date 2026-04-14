class HomeTheaterFacade {
    private TV tv;
    private Projetor projetor;
    private Som som;
    private PlayerMidia player;
    private Luzes luzes;

    public HomeTheaterFacade(TV tv, Projetor projetor, Som som, PlayerMidia player, Luzes luzes) {
        this.tv = tv;
        this.projetor = projetor;
        this.som = som;
        this.player = player;
        this.luzes = luzes;
    }

    public void assistirFilme(String filme) {
        System.out.println("Preparando tudo para o filme...");
        luzes.ajustar(10);
        projetor.ligar();
        som.ligar();
        som.setVolume(50);
        player.ligar();
        player.play(filme);
    }

    public void ouvirMusica() {
        System.out.println("Configurando ambiente para música...");
        luzes.ajustar(40);
        tv.ligar();
        som.ligar();
        som.setVolume(30);
    }

    public void encerrar() {
        System.out.println("Desligando Home Theater...");
        luzes.ajustar(100);
        projetor.desligar();
        tv.desligar();
    }
}