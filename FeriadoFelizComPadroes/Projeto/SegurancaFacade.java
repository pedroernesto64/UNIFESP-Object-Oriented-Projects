// ======================================================
// 8. FACADE: Interface simplificada para o usuário final
// ======================================================
class SegurancaFacade implements Observer {
    private AlertaStrategy estrategia = new AlertaSonoro();
    private Notificacao notificacao = new DecoratorData(new NotificacaoBasica());
    private CameraModerna camera = new AdaptadorCamera(new Adapter());

    public void configurarEArmar(String senha) {
        LogSistema.getInstancia().registrar("Iniciando processo de armamento...");
        InterfaceAlarme alarme = new AlarmeProxy(senha);
        alarme.armar();
    }

    public void update(String sensorNome) {
        System.out.println(notificacao.formatar("Evento detectado por: " + sensorNome));
        camera.tirarFoto();
        estrategia.executarAlerta();
    }
}