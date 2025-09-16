public class Alunno {
  String nome;
  String cognome;
  int età;

  public static Alunno parseAlunno(String record) {
    Alunno alunno = new Alunno();
    String[] alunnoRecord = record.split(",");
    alunno.nome = alunnoRecord[0];
    alunno.cognome = alunnoRecord[1];
    alunno.età = Integer.parseInt(alunnoRecord[2]);
    return alunno;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}
