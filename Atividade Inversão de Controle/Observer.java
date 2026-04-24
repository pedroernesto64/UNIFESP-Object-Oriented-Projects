// Interface que define o contrato de "callback"
// Representa o ponto onde o código customizado se encaixa no framework.
interface Observer {
    void update(Subject s, Property p);    
}