class NotificationProxy implements Notification {
    private Notification realNotification;
    private Global config = Global.getInstance();

    public NotificationProxy(Notification realNotification) {
        this.realNotification = realNotification;
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Tentativa de envio via: " + config.getAppName());
        
        if (message == null || message.isEmpty()) {
            System.out.println("[ERRO] Mensagem vazia não permitida.");
            return;
        }
        
        realNotification.send(message);
    }
}