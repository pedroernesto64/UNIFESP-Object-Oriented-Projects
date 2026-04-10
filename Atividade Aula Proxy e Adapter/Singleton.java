class Global {
    private Global() {}
    private static Global instance;

    private String appName = "Sistema de Notificações";
    private String smtpServer = "smtp.notifica.com";
    private int maxRetries = 3;

    public static Global getInstance() {
        if (instance == null)
            instance = new Global();
        return instance;
    }

    // Getters
    public String getAppName() { return appName; }
    public String getSmtpServer() { return smtpServer; }
    public int getMaxRetries() { return maxRetries; }

}