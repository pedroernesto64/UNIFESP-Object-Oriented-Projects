class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}