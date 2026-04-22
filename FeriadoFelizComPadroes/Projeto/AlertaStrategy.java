// ======================================================
// 2. STRATEGY: Diferentes modos de alerta
// ======================================================
interface AlertaStrategy {
    void executarAlerta();
}

class AlertaSilencioso implements AlertaStrategy {
    public void executarAlerta() { System.out.println("-> Alerta: Enviando notificação silenciosa para a polícia."); }
}

class AlertaSonoro implements AlertaStrategy {
    public void executarAlerta() { System.out.println("-> Alerta: Tocando sirene de 120dB!"); }
}