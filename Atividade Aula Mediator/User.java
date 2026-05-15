public class User extends Colegue {
    public User(Mediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " envia a mensagem: " + message);
        med.sendMessage(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " recebe" + message);
    }
}
