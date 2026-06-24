import java.util.HashMap;

public class BancoPessoas {
    private HashMap<String, Command> comandos = new HashMap<>();

    // Método para a Main cadastrar os comandos criados externamente
    public void registrarComando(String nome, Command comando) {
        comandos.put(nome, comando);
    }

    public void processar(String[] args) {
        if (args.length == 0) {
            System.out.println("Sintaxe: java BancoPessoas <comando> [<args>]");
            return;
        }

        String nomeComando = args[0];
        Command comando = comandos.get(nomeComando);

        if (comando != null) {
            comando.execute(args);
        } else {
            System.out.println("Comando desconhecido: " + nomeComando);
        }
    }
}