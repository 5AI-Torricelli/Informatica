import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    static String XML;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        leggiFile("persone.xml");
        int scelta = -1;

        while (scelta != 0) {
            System.out.println("[1] Stampa tutti gli indirizzi email");
            System.out.println("[2] Stampa l'indirizzo email di una persona");
            System.out.println("[0] Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (scelta) {
                case 1:
                    System.err.println("Stampa di tutti gli indirizzi email");
                    stampaEmail();
                    break;
                case 2:
                    System.err.println("Ricerca della persona");
                    System.out.println("Inserisci nome da cercare:");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci cognome da cercare:");
                    String cognome = scanner.nextLine();
                    stampaEmail(nome, cognome);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
    }

    // Stampa tutte le email
    public static void stampaEmail() {
        int numeroPersone = XML.split("<Person").length - 1;
        for (int i = 0; i < numeroPersone; i++) {
            String email = XML.split("<Email>")[i + 1];
            email = email.split("</Email>")[0];
            System.out.println(email);
        }
    }

    // Questa è una parte più complicata e non obbligatoria
    // Di base stampa l'email cercandola tramite il nome e il cognome
    public static void stampaEmail(String nome, String cognome) {
        String[] persone = XML.split("<Person");
        // Utilizziamo questo metodo per escludere il primo elemento 
        // del vettore di stringhe, essendo che questo non rappresenta una persona
        //
        // Il metodo richiede: il vettore, l'indice dal quale partire, la grandezza del vettore.
        persone = Arrays.copyOfRange(persone, 1, persone.length);

        for (String persona : persone) {
            persona = persona.split("</Person>")[0];
            String given = persona.split("<Given>")[1];
            given = given.split("</Given>")[0];
            String family = persona.split("<Family>")[1];
            family = family.split("</Family>")[0];
            if (given.equalsIgnoreCase(nome) && family.equalsIgnoreCase(cognome)) {
                System.out.println(given + " " + family + ":");
                String email = persona.split("<Email>")[1];
                email = email.split("</Email>")[0];
                System.out.println(email);
                // Fermiamo il ciclo for e terminiamo la funzione quando trovato
                return;
            }
        }
        // Se nulla è stato trovato, 
        // allora il ciclo for termina e il codice stamperà questo
        System.out.println("Nessuna persona con queste caratteristiche è stata trovata.");
        System.out.println();
    }

    // Questo metodo ha l'unico scopo di mettere
    // nella variabile "XML" il contenuto del file XML
    public static void leggiFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                XML += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
