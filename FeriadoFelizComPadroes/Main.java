public class Main {
    public static void main(String[] args) {
        SegurancaFacade facade = new SegurancaFacade();
        facade.configurarEArmar("1234");

        SensorMovimento sensor = (SensorMovimento) SensorFactory.criarSensor("movimento");
        sensor.addObserver(facade);
        sensor.detectar();
    }
}