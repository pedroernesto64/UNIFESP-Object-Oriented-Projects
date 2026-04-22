// ======================================================
// 3. OBSERVER: Sensores que notificam o painel central
// ======================================================
interface Observer {
    void update(String sensorNome);
}

class Sujeito {
    private List<Observer> observadores = new ArrayList<>();
    public void addObserver(Observer o) { observadores.add(o); }
    public void notificar(String nome) {
        for (Observer o : observadores) o.update(nome);
    }
}

class SensorMovimento extends Sujeito {
    public void detectar() {
        System.out.println("Sensor detectou movimento!");
        notificar("Sensor Sala");
    }
}