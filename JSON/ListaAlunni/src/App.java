import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    static String NOME_FILE = "alunni.json";
    static Scanner scanner = new Scanner(System.in);
    static StringBuilder json = new StringBuilder();

    public static void main(String[] args) throws Exception {
        json = json.append("[\n{\"nome\":\"Test\",\"cognome\":\"Test 2\"},\n{\"nome\":\"Test 3\",\"cognome\":\"Test 4\"}\n]");
        int scelta = -1;
        System.out.println(json.toString());
        while (scelta != 0) {
            System.out.println("1. Aggiungi alunni");
            System.out.println("2. Rimuovi alunni");
            System.out.println("3. Azzera e aggiungi");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 1:
                    aggiungiAlunni();           
                    String contenutoFile = leggiFile(NOME_FILE);
                    System.out.print(contenutoFile);
                    break;
                case 2:
                    rimuoviAlunno();
                    break;
                case 0:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }
        }
        scanner.close();
    }

    public static void aggiungiAlunni() {
        System.out.println("Inserisci il numero di alunni:");
        int numeroAlunni = scanner.nextInt();
        scanner.nextLine();

        if (json.toString().isEmpty()) {
            json.append("[\n");
        } else {
            json.delete(json.length()-2, json.length());
            json.append(",\n");
        }
        for (int i = 0; i < numeroAlunni; i++) {
            json.append(compilaAlunno());
            if (i < numeroAlunni - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("]");

        scriviFile(NOME_FILE, json.toString());
    }

    public static void rimuoviAlunno() {
        System.out.println("Trova l'alunno da rimuovere:");
        String alunno = compilaAlunno();
        int alunnoTrovato = json.indexOf(alunno);
        if (alunnoTrovato == -1) {
            System.out.println("Alunno non trovato");
            return;
        }
        int nonUltimo = 0;
        if (json.charAt(alunnoTrovato+alunno.length()) == ',') {
            System.out.println("Non era ultimo");
            nonUltimo = 1;
        }
        json.replace(alunnoTrovato-1, alunnoTrovato+alunno.length()+nonUltimo, "");
        if (json.toString().endsWith("},\n]")) {
            json.deleteCharAt(json.length()-3);
        }
        System.err.println(json.toString());
    }

    public static String compilaAlunno() {
        System.out.println("Inserisci il nome dell'alunno ");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome dell'alunno ");
        String cognome = scanner.nextLine();
        return "{\"nome\":\""+nome+"\",\"cognome\":\""+cognome+"\"}";
    }

    public static void scriviFile(String nomeFile, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            writer.write(content);
        } catch (Exception e) {
            System.err.println("Errore nella scrittura file.");
        }
    }

    public static String leggiFile(String nomeFile) {
        String content = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
        } catch (Exception e) {
            System.err.println("Errore nella lettura file.");
        }
        return content;
    }
}
