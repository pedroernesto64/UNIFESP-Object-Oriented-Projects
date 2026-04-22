// ======================================================
// 7. PROXY: Controle de acesso ao alarme (Verifica senha)
// ======================================================
interface InterfaceAlarme {
    void armar();
}

class AlarmeReal implements InterfaceAlarme {
    public void armar() { System.out.println("Alarme armado com sucesso."); }
}

class AlarmeProxy implements InterfaceAlarme {
    private AlarmeReal alarmeReal = new AlarmeReal();
    private String senhaCorreta = "1234";
    private String senhaInformada;

    public AlarmeProxy(String senha) { this.senhaInformada = senha; }

    public void armar() {
        if (senhaCorreta.equals(senhaInformada)) {
            alarmeReal.armar();
        } else {
            System.out.println("Acesso negado: Senha incorreta.");
        }
    }
}