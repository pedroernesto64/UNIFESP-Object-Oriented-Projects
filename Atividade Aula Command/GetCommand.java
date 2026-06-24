import java.util.HashMap;

class GetCommand implements Command {
    private HashMap<Integer, Pessoa> db;

    public GetCommand(HashMap<Integer, Pessoa> db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso correto: get <id>");
            return;
        }
        int id = Integer.parseInt(args[1]);
        Pessoa p = db.get(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
}