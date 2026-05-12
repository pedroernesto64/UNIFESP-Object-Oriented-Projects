public class Main {
	public static void main(String[] args) {
		GerenciadorReservas gm = GerenciadorReservas.getInstance();

		Usuario u1 = new Usuario("Alice");
		Usuario u2 = new Usuario("Bob");

		gm.addObserver(u1);
		gm.addObserver(u2);

		gm.setPoliticaStrategy(new PrimeiroAReservarStrategy());

		Sala s = FactorySala.create("indiv");
		Reserva r = new Reserva(u1, s, "2026-05-12 10:00");

		boolean ok = gm.criarReserva(r);
		System.out.println("Reserva criada? " + ok);
	}
}
