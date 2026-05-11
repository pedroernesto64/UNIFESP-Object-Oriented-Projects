class GerenciadorReserva {
  private PoliticaColisao strategy;

  private GerenciadorReserva() {}          // proíbe clientes de chamarem new GerenciadorReserva()‏
  
  private static GerenciadorReserva instance;           // instância única da classe
  
  public static GerenciadorReserva getInstance() {
    if(instance == null)        // primeira vez que se chama getInstance
      instance = new GerenciadorReserva();
    return instance;
  }

  public void setPoliticaStrategy(PoliticaColisao strategy){
    this.strategy = strategy;
  }
  
  public void criarReserva() {
    
  }

  public void removerReserva() {
    
  }

  public void getSalasDisponiveis(){

  }
  

}

