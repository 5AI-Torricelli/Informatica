public class Alunno {
  private String nome;
  private String cognome;
  private int età;
  private String classe;

  public static Alunno parseAlunno(String record) {
    // Creo un oggetto Alunno vuoto
    Alunno alunno = new Alunno();
    // Divido la stringa in substrings utilizzando il carattere ";" come separatore
    String[] alunnoRecord = record.split(";");
    // Imposto il nome dell'alunno
    alunno.nome = alunnoRecord[0];
    // Imposto il cognome dell'alunno
    alunno.cognome = alunnoRecord[1];
    // Imposto l'eta dell'alunno dopo averla convertita in un numero intero
    alunno.età = Integer.parseInt(alunnoRecord[2]);
    // Imposto la classe dell'alunno
    alunno.classe = alunnoRecord[3];
    // Ritorno l'oggetto Alunno creato
    return alunno;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public int getEtà() {
    return età;
  }

  public void setEtà(int età) {
    this.età = età;
  }

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  @Override
  public String toString() {
    // Creo una stringa vuota per contenere il risultato
    String risultato = "";
    // Aggiungo il nome e cognome dell'alunno al risultato
    risultato += String.format("Alunno %s %s\n", nome, cognome);
    // Aggiungo il nome dell'alunno al risultato
    risultato += String.format("Nome: %s\n", nome);
    // Aggiungo il cognome dell'alunno al risultato
    risultato += String.format("Cognome: %s\n", cognome);
    // Aggiungo l'età dell'alunno al risultato
    risultato += String.format("Età: %d\n", età);
    // Aggiungo la classe dell'alunno al risultato
    risultato += String.format("Classe: %s\n", classe);
    // Restituisco la stringa completa come risultato
    return risultato;
  }

  public String toCSV() {
    // Creo una stringa dove ogni elemento è a un certo ordine e tutti sono separati da ";"
    return String.format("%s;%s;%d;%s", nome, cognome, età, classe);
  }
}
