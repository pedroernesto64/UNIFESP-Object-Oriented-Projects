// ======================================================
// 4. FACTORY: Centraliza a criação de sensores
// ======================================================
class SensorFactory {
    public static Sujeito criarSensor(String tipo) {
        if (tipo.equals("movimento")) return new SensorMovimento();
        return null;
    }
}
