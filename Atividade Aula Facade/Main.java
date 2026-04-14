public class Main {
    public static void main(String[] args) {
        // Subsistemas instanciados
        TV tv = new TV();
        Projetor p = new Projetor();
        Som s = new Som();
        PlayerMidia pm = new PlayerMidia();
        Luzes l = new Luzes();

        // Cliente usa apenas a Fachada
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, p, s, pm, l);
        
        homeTheater.assistirFilme("Interestelar");
        homeTheater.encerrar();
    }
}