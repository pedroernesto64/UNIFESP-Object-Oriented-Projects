import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criando a Facade
        SegurancaFacade facade = new SegurancaFacade();

        // 1. Armar sistema (Proxy e Singleton)
        facade.configurarEArmar("1234");

        // 2. Criar sensor e registrar observador (Factory e Observer)
        SensorMovimento sensor = (SensorMovimento) SensorFactory.criarSensor("movimento");
        sensor.addObserver(facade);

        // 3. Simular detecção (Dispara Observer, Decorator, Adapter e Strategy)
        System.out.println("\n--- Simulando Invasão ---");
        sensor.detectar();
    }
}