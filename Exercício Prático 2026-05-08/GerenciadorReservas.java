class GerenciadorReserva {
  private GerenciadorReserva() {}          // proíbe clientes de chamarem new GerenciadorReserva()‏
  
  private static GerenciadorReserva instance;           // instância única da classe
  
  public static GerenciadorReserva getInstance() {
    if(instance == null)        // primeira vez que chama-se getInstance
      instance = new GerenciadorReserva();
    return instance;
  }
  
  public void criarReserva() {
    
  }

  public void removerReserva() {
    
  }

  public void getSalasDisponiveis(){

  }
  

}

