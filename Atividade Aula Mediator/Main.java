// Pedro Ernesto Duarte Pilchowski - RA: 156.331
// Exercício Mediator - Projetos Orientados a Objetos

public class Main {
    public static void main(String[] args) {
        Mediator chat = new ChatMediator();

        User maria = new User(chat, "Maria");
        User joao = new User(chat, "João");
        User carlos = new User(chat, "Carlos");
        User ana = new User(chat, "Ana");

        chat.addUser(maria);
        chat.addUser(joao);
        chat.addUser(carlos);
        chat.addUser(ana);

        maria.send("Oieeee!");
        joao.send("Faaaala");
        chat.removeUser(carlos);
        ana.send("Suave");
    }
}