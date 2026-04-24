// Implementação concreta do Observer
// Código cliente que é "chamado" pelo framework quando um evento ocorre.
class Universidade implements Observer {
    private String nome;
    public Universidade(String nome) { this.nome = nome; }

    @Override
    public void update(Subject s, Property p) {
        // Implementação do callback: o que fazer quando o estado muda
        if (s instanceof PCD) {
            PCD pcd = (PCD) s;
            System.out.println(this.nome + " detectou mudança de " + p + " em " + pcd.getNome());
        }
    }
}