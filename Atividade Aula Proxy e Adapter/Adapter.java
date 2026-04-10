interface Notification {
    void send(String message);
}

class ExternalSMSAPI {
    public void executeSend(String msg, int priority) {
        System.out.println("API Externa enviando: " + msg + " (Prioridade: " + priority + ")");
    }
}

class SMSAdapter implements Notification {
    private ExternalSMSAPI api;

    public SMSAdapter(ExternalSMSAPI api) {
        this.api = api;
    }

    @Override
    public void send(String message) {
        api.executeSend(message, 1);
    }
}