public class App {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser("alunni.csv");
        parser.leggiFile();
        parser.stampaAlunni();
    }
}
