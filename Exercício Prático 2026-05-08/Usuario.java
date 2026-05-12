public class Usuario implements Observer {
	private final String nome;

	public Usuario(String nome) {
		this.nome = nome;
	}

	@Override
	public void update(Subject s, Property p) {
		System.out.println("[Usuario:" + nome + "] Notificação recebida: " + p);
	}

	public String toString() { return nome; }

}
