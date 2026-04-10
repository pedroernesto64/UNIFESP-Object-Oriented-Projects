// Interface comum do sistema
interface Notification {
    void send(String message);
}

// Classe do Fabricante (Legada/Externa) com interface incompatível
class ExternalSMSAPI {
    public void executeSend(String msg, int priority) {
        System.out.println("API Externa enviando: " + msg + " (Prioridade: " + priority + ")");
    }
}

// Adaptador para integrar a API externa ao nosso sistema
class SMSAdapter implements Notification {
    private ExternalSMSAPI api;

    public SMSAdapter(ExternalSMSAPI api) {
        this.api = api;
    }

    @Override
    public void send(String message) {
        // Traduz a chamada 'send' para o método específico da API 'executeSend'
        api.executeSend(message, 1);
    }
}