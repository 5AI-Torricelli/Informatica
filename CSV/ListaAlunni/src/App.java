import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Creo un oggetto per gestire il registro degli alunni
        Registro registro = new Registro("alunni.csv");
        // Leggo il file e lo carico nel registro
        registro.leggiFile();
        // Creo un oggetto per leggere da stdin
        Scanner scanner = new Scanner(System.in);
        // Variabile per contenere la scelta dell'utente
        int scelta = -1;
        
        // Ciclo while per gestire le scelte dell'utente
        while (scelta != 0) {
            // Stampo le opzioni possibili
            System.out.println("[1] Aggiungi alunno");
            System.out.println("[2] Rimuovi alunno");
            System.out.println("[3] Stampa tutti gli alunni");
            System.out.println("[4] Salva file");
            System.out.println("[0] Esci");
            System.out.println("");
            // Chiedo all'utente di selezionare un'opzione
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            // Consumo la newline rimasta nel buffer
            scanner.nextLine();

            // Switch per gestire le scelte dell'utente
            switch (scelta) {
                case 1:
                    // Chiedo le informazioni per aggiungere un alunno
                    System.out.println("Dammi il nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Dammi il cognome:");
                    String cognome = scanner.nextLine();
                    System.out.println("Dammi l'età:");
                    int eta = scanner.nextInt();
                    // Consumo la newline rimasta nel buffer
                    scanner.nextLine();
                    System.out.println("Dammi la classe:");
                    String classe = scanner.nextLine();
                    // Aggiungo l'alunno al registro
                    registro.aggiungiAlunno(nome, cognome, eta, classe);
                    break;
                case 3:
                    // Variabile per contenere la scelta dell'utente per la stampa
                    int sceltaStampa = -1;
                    // Array per contenere le colonne selezionate per la stampa
                    String[] colonneSelezionate = new String[4];

                    // Ciclo while per gestire le scelte dell'utente per la stampa
                    while (sceltaStampa != 0) {
                        // Stampo le opzioni possibili
                        System.out.println("");
                        System.out.println("Seleziona le colonne da stampare:");
                        System.out.println(String.format("[%s] Nome", (colonneSelezionate[0] == "X") ? "X" : "1"));
                        System.out.println(String.format("[%s] Cognome", (colonneSelezionate[1] == "X") ? "X" : "2"));
                        System.out.println(String.format("[%s] Età", (colonneSelezionate[2] == "X") ? "X" : "3"));
                        System.out.println(String.format("[%s] Classe", (colonneSelezionate[3] == "X") ? "X" : "4"));
                        System.out.println("[5] Seleziona tutto e stampa");
                        System.out.print("Scelta (0 per concludere): ");
                        sceltaStampa = scanner.nextInt();
                        scanner.nextLine();

                        if (sceltaStampa == 5) {
                            // Seleziona tutte le colonne e stampo
                            for (int i = 0; i < colonneSelezionate.length; i++) {
                                colonneSelezionate[i] = "X";
                            }
                            break;
                        }
                        if (sceltaStampa != 0) {
                            // Seleziona la colonna selezionata
                            if (sceltaStampa >= 1 && sceltaStampa <= 4) {
                                if (colonneSelezionate[sceltaStampa-1] == "X") {
                                    colonneSelezionate[sceltaStampa-1] = String.valueOf(sceltaStampa);
                                } else {
                                    colonneSelezionate[sceltaStampa-1] = "X";
                                }
                            } else {
                                System.out.println("Scelta non valida");
                            }
                        }
                    }
                    // Stampo il registro selezionato
                    System.out.println("");
                    System.out.println("Ecco il registro selezionato");
                    // Stampo il registro selezionato
                    registro.stampaAlunni(colonneSelezionate);
                    break;

                case 4:
                    // Salvo il file
                    registro.salvaFile();
                    System.out.println("File salvato con successo");
                    System.out.println("");
                    break;

                case 0:
                    // Esci dal programma
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        // Chiudo lo scanner
        scanner.close();
    }
}

