// ======================================================
// 1. SINGLETON: Log central do sistema
// ======================================================
class LogSistema {
    private static LogSistema instancia;
    private LogSistema() {}

    public static LogSistema getInstancia() {
        if (instancia == null) instancia = new LogSistema();
        return instancia;
    }

    public void registrar(String msg) {
        System.out.println("[LOG GLOBAL] " + msg);
    }
}