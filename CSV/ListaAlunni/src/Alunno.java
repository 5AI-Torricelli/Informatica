public class Alunno {
  private String nome;
  private String cognome;
  private int età;
  private String classe;

  public static Alunno parseAlunno(String record) {
    Alunno alunno = new Alunno();
    String[] alunnoRecord = record.split(";");
    alunno.nome = alunnoRecord[0];
    alunno.cognome = alunnoRecord[1];
    alunno.età = Integer.parseInt(alunnoRecord[2]);
    alunno.classe = alunnoRecord[3];
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
    String risultato = "";
    risultato += String.format("Alunno %s %s\n", nome, cognome);
    risultato += String.format("Nome: %s\n", nome);
    risultato += String.format("Cognome: %s\n", cognome);
    risultato += String.format("Età: %d\n", età);
    risultato += String.format("Classe: %s\n", classe);
    return risultato;
  }

  public String toCSV() {
    return String.format("%s;%s;%d;%s", nome, cognome, età, classe);
  }
}
