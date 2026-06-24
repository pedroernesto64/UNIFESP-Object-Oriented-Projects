import java.util.HashMap;

class NewCommand implements Command {
    private HashMap<Integer, Pessoa> db;

    public NewCommand(HashMap<Integer, Pessoa> db) {
        this.db = db;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso correto: new <id> <nome>");
            return;
        }
        int id = Integer.parseInt(args[1]);
        String nome = args[2];
        db.put(id, new Pessoa(id, nome));
        System.out.println("Pessoa adicionada com sucesso.");
    }
}