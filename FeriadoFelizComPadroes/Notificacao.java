// ======================================================
// 6. DECORATOR: Adicionar funcionalidades à notificação
// ======================================================
import java.util.Date;

interface Notificacao {
    String formatar(String msg);
}

class NotificacaoBasica implements Notificacao {
    public String formatar(String msg) { return msg; }
}

class DecoratorData implements Notificacao {
    private Notificacao base;
    public DecoratorData(Notificacao n) { this.base = n; }
    public String formatar(String msg) { return "[" + new Date() + "] " + base.formatar(msg); }
}