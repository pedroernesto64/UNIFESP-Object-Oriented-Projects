interface Notification {}

class emailNotification implements Notification {}
class pushNotification implements Notification {}
class smsNotification implements Notification {}

class NotificationFactory {
    public static Notification create(String mean) {
        Notification notification;
        
        switch (mean.toLowerCase()) {
            case "email":
                notification = new EmailNotification(); // Classe concreta básica
                break;
            case "sms":
                // Instancia o adaptador para a API externa
                notification = new SMSAdapter(new ExternalSMSAPI());
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido");
        }
        
        // Retorna o Proxy envolvendo a notificação criada
        return new NotificationProxy(notification);
    }
}

public class Factory { 

  void f() {
    Notification n = NotificationFactory.create("email");  
  }

  void g() {
    Notification n = NotificationFactory.create("push");
  }
  
  void h() {
    Notification n = NotificationFactory.create("sms");
  }
  
  public static void main(String [] args) {
     Factory m = new Factory();
     m.f();
     m.g();
     m.h(); 
  }

}