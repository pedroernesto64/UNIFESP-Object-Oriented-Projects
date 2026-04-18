class PCD extends Subject {
    private double temp;
    private double ph;
    private double umid_ar;
    private String nome;

    public PCD (String nome){
        this.nome=nome;
    }

    public String getNome() {
        return this.nome;
    }

    public double getTemp() {
        return temp;
    }
    public double getPh() {
        return ph;
    }
    public double getUmidAr() {
        return umid_ar;
    }

    public void setTemp(double temp) {
        this.temp = temp;
        notifyObservers(Property.TEMP);
    }
    public void setPh(double ph) {
        this.ph = ph;
        notifyObservers(Property.PH);
    }
    public void setUmidAr(double umid_ar) {
        this.umid_ar = umid_ar;
        notifyObservers(Property.UMID_AR);
    }

}