// O "Framework"
// Controla o fluxo de execução (IoC). Ele decide quando e como os observadores são avisados.
import java.util.ArrayList;
import java.util.List;

abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método central do framework que realiza a Inversão de Controle
    // O modelo "chama de volta" (callback) os observadores registrados.
    protected void notifyObservers(Property p) {
        for (Observer obs : observers) {
            obs.update(this, p); 
        }
    }
}