// Extensão do Framework (Código Customizado)
// Define o estado específico, mas depende do Subject para a lógica de notificação.
class PCD extends Subject {
    private double temp;
    private double ph;
    private double umid_ar;
    private String nome;

    public PCD(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public double getTemp() { return temp; }
    public double getPh() { return ph; }
    public double getUmidAr() { return umid_ar; }

    // Ao alterar o estado, o controle é passado para o framework (notifyObservers)
    public void setTemp(double temp) {
        this.temp = temp;
        notifyObservers(Property.TEMP);
    }
    // ... métodos setPh e setUmidAr seguem a mesma lógica
}