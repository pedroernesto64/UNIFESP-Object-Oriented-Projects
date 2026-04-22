// ======================================================
// 5. ADAPTER: Adaptar uma câmera antiga ao sistema novo
// ======================================================
class CameraAntiga { 
    public void capturarImagemAntiga() { System.out.println("Capturando imagem legada..."); }
}

interface CameraModerna {
    void tirarFoto();
}

class AdaptadorCamera implements CameraModerna {
    private CameraAntiga cameraAntiga;
    public AdaptadorCamera(CameraAntiga c) { this.cameraAntiga = c; }
    public void tirarFoto() { cameraAntiga.capturarImagemAntiga(); }
}