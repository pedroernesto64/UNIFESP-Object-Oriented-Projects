public class FactorySala {
    public static Sala create(String tipo) {
        switch (tipo) {
            case "indiv":
                System.out.println("Reservando sala de estudo individual...");
                return new SalaEstudoIndividual();

            case "grupo":
                System.out.println("Reservando sala de trabalho em grupo...");
                return new SalaTrabalhoGrupo();

            case "lab":
                System.out.println("Reservando laboratório...");
                return new SalaLaboratorio();

            default:
                System.out.println("Reservando sala de estudo individual...");
                return new SalaEstudoIndividual();
        }
    }
}
