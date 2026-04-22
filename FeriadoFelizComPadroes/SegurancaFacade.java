// ======================================================
// 8. FACADE: Interface simplificada para o usuário final
// ======================================================
class SegurancaFacade implements Observer {
    private AlertaStrategy estrategia = new AlertaSonoro();
    private Notificacao notificacao = new DecoratorData(new NotificacaoBasica());
    private CameraModerna camera = new AdaptadorCamera(new CameraAntiga());

    public void configurarEArmar(String senha) {
        LogSistema.getInstancia().registrar("Armando sistema...");
        InterfaceAlarme alarme = new AlarmeProxy(senha);
        alarme.armar();
    }

    public void update(String sensorNome) {
        System.out.println(notificacao.formatar("Evento em: " + sensorNome));
        camera.tirarFoto();
        estrategia.executarAlerta();
    }
}