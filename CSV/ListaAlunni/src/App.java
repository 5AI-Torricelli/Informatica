import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Registro registro = new Registro("alunni.csv");
        registro.leggiFile();
        Scanner scanner = new Scanner(System.in);
        int scelta = -1;
        
        while (scelta != 0) {
            System.out.println("[1] Aggiungi alunno");
            System.out.println("[2] Rimuovi alunno");
            System.out.println("[3] Stampa tutti gli alunni");
            System.out.println("[4] Salva file");
            System.out.println("[0] Esci");
            System.out.println("");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Dammi il nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Dammi il cognome:");
                    String cognome = scanner.nextLine();
                    System.out.println("Dammi l'età:");
                    int eta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Dammi la classe:");
                    String classe = scanner.nextLine();
                    registro.aggiungiAlunno(nome, cognome, eta, classe);
                    break;
                case 3:
                    int sceltaStampa = -1;
                    String[] colonneSelezionate = new String[4];

                    while (sceltaStampa != 0) {
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
                            for (int i = 0; i < colonneSelezionate.length; i++) {
                                colonneSelezionate[i] = "X";
                            }
                            break;
                        }
                        if (sceltaStampa != 0) {
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
                    System.out.println("");
                    System.out.println("Ecco il registro selezionato");
                    registro.stampaAlunni(colonneSelezionate);
                    break;

                case 4:
                    registro.salvaFile();
                    System.out.println("File salvato con successo");
                    System.out.println("");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        scanner.close();
    }
}
