public abstract class Colegue {
    protected Mediator med;
    protected String name;

    public Colegue(Mediator med, String name) {
        this.med = med;
        this.name = name;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}
