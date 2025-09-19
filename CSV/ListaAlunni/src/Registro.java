import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

// Classe per gestire un registro di alunni
public class Registro {
  // File del registro
  public String file;
  // Arraylist per contenere gli alunni
  public ArrayList<Alunno> alunni = new ArrayList<Alunno>();

  // Costruttore per inizializzare il registro
  public Registro(String file) {
    this.file = file;
  }

  // Stampa tutti gli alunni selezionando le colonne da stampare
  public void stampaAlunni(String[] colonneSelezionate) {
    String risultato;
    for (Alunno alunno : alunni) {
      risultato = "";
      risultato += String.format("Alunno %s %s\n", alunno.getNome(), alunno.getCognome());
      // Se la colonna selezionata contiene "X", stampa la colonna
      if (colonneSelezionate[0] == "X") {
        risultato += String.format("Nome: %s\n", alunno.getNome());
      }
      if (colonneSelezionate[1] == "X") {
        risultato += String.format("Cognome: %s\n", alunno.getCognome());
      }
      if (colonneSelezionate[2] == "X") {
        risultato += String.format("Età: %d\n", alunno.getEtà());
      }
      if (colonneSelezionate[3] == "X") {
        risultato += String.format("Classe: %s\n", alunno.getClasse());
      }
      // Stampa il risultato
      System.out.println(risultato);
    }
  }

  // Stampa tutti gli alunni
  public void stampaAlunni() {
    for (Alunno alunno : alunni) {
      System.out.println(alunno.toString());
    }
  }

  // Aggiunge un alunno al registro
  public void aggiungiAlunno(String nome, String cognome, int eta, String classe) {
    Alunno alunno = new Alunno();
    alunno.setNome(nome);
    alunno.setCognome(cognome);
    alunno.setEtà(eta);
    alunno.setClasse(classe);
    alunni.add(alunno);
  }

  // Leggi il file e carica il registro
  public void leggiFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      reader.readLine(); // Salta la prima riga del file
      while ((line = reader.readLine()) != null) {
        alunni.add(Alunno.parseAlunno(line));
      }
    } catch (Exception e) {
      System.err.println("Errore nell'aprire il file");
      e.printStackTrace();
    }
  }

  // Salva il file
  public void salvaFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String header = reader.readLine(); // Leggiamo la prima riga del file per preservare gli header
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(header + "\n");
        for (Alunno alunno : alunni) {
          writer.write(alunno.toCSV() + "\n");
        }
      } catch (Exception e) {
        System.err.println("Errore nel salvare il file");
        e.printStackTrace();
      }
    } catch (Exception e) {
      System.err.println("Errore nell'aprire il file");
      e.printStackTrace();
    }
  }
}
