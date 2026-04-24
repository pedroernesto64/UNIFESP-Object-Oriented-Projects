public class Main {
    public static void main(String[] args) {
        PCD pcd1 = new PCD("PCD1");
        PCD pcd2 = new PCD("PCD2");
        PCD pcd3 = new PCD("PCD3");
        PCD pcd4 = new PCD("PCD4");
        PCD pcd5 = new PCD("PCD5");
    
        Universidade unifesp = new Universidade("Unifesp");
        Universidade ufpr = new Universidade("UFPR");
        Universidade ufms = new Universidade("UFMS");

        pcd1.addObserver(ufms);
        pcd2.addObserver(unifesp);
        pcd3.addObserver(ufpr);
        pcd4.addObserver(ufms);
        pcd4.addObserver(unifesp);
        pcd5.addObserver(ufpr);
        pcd5.addObserver(ufms);
        pcd5.addObserver(unifesp);

        pcd5.setTemp(16);
        pcd2.setPh(11);
        pcd1.setUmidAr(90);
    }
}