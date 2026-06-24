import java.util.HashMap;

class AllCommand implements Command {
    private HashMap<Integer, Pessoa> db;

    public AllCommand(HashMap<Integer, Pessoa> db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (db.isEmpty()) {
            System.out.println("Banco de dados vazio.");
            return;
        }
        for (Pessoa p : db.values()) {
            System.out.println(p);
        }
    }
}