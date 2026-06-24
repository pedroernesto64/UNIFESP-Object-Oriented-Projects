import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 1. Instancia o "Banco de Dados" (Receiver) que será compartilhado
        HashMap<Integer, Pessoa> databaseCompartilhado = new HashMap<>();

        // 2. Instancia o Invocador (Invoker)
        BancoPessoas sistema = new BancoPessoas();

        // 3. Registra os comandos injetando o banco de dados compartilhado
        // Isso garante que todos os comandos operem sobre a mesma base de dados
        sistema.registrarComando("new", new NewCommand(databaseCompartilhado));
        sistema.registrarComando("delete", new DeleteCommand(databaseCompartilhado));
        sistema.registrarComando("get", new GetCommand(databaseCompartilhado));
        sistema.registrarComando("all", new AllCommand(databaseCompartilhado));

        // 4. Executa a lógica com os argumentos vindos do terminal
        sistema.processar(args);
    }
}