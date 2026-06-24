import java.util.HashMap;

class DeleteCommand implements Command {
    private HashMap<Integer, Pessoa> db;

    public DeleteCommand(HashMap<Integer, Pessoa> db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso correto: delete <id>");
            return;
        }
        int id = Integer.parseInt(args[1]);
        if (db.remove(id) != null) {
            System.out.println("Pessoa removida.");
        } else {
            System.out.println("ID não encontrado.");
        }
    }
}