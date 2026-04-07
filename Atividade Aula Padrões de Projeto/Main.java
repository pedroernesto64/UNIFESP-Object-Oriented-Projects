interface Notification {}

class emailNotification implements Notification {}
class pushNotification implements Notification {}
class smsNotification implements Notification {}

class NotificationFactory {

    public static Notification create (String mean) {
        switch (mean.toLowerCase()) {
            case "email":
                System.out.println("Enviando email...");
                return new emailNotification();

            case "push":
                System.out.println("Enviando push...");
                return new emailNotification();

            case "sms":
                System.out.println("Enviando sms...");
                return new emailNotification();
            
            default:
                throw new IllegalArgumentException("Tipo de notifiação inválido: ");
        }        
    }
}

public class Main { 

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
     Main m = new Main();
     m.f();
     m.g();
     m.h(); 
  }

}