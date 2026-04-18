class Universidade implements Observer  {
  private String nome;
  public Universidade(String nome) {
    this.nome=nome;
  }

  public void update(Subject s, Property p) {
    switch (p) {
      case TEMP:
        double temp = ((PCD) s).getTemp();
        System.out.println(this.nome + " notifica:");
        System.out.println(((PCD) s).getNome() + " atualizou sua temperatura.");
        System.out.println("Temperatura em Celsius: " + temp + "\n");
        break;
    
      case PH:
        double ph = ((PCD) s).getPh();
        System.out.println(this.nome + " notifica:");
        System.out.println(((PCD) s).getNome() + " atualizou seu Ph.");
        System.out.println("Ph: " + ph + "\n");
        break;

      case UMID_AR:
        double umid_ar = ((PCD) s).getUmidAr();
        System.out.println(this.nome + " notifica:");
        System.out.println(((PCD) s).getNome() + " atualizou sua umidade do ar.");
        System.out.println("Umidade do ar: " + umid_ar + "%\n");
        break;
    }
  }
}