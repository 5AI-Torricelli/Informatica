import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Parser {
  public String file;
  public ArrayList<Alunno> alunni;

  public Parser(String file) {
    this.file = file;
  }

  public void stampaAlunni() {
    for (Alunno alunno : alunni) {
      System.out.println(alunno.toString());
    }
  }

  public void leggiFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        alunni.add(Alunno.parseAlunno(line));
      }
    } catch (Exception e) {
      System.err.println("Errore nell'aprire il file");
    }
  }
}
