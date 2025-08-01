import org.xml.sax.SAXNotRecognizedException;


public class Ministerios extends Cadastro {
  String descricao;

  Ministerios(String nome, String descricao) {
    super(nome);
    this.descricao = descricao;
  }

  public String getDescricao(){
    return descricao;
  }

  public void setDescricao(String descricao){
    this.descricao=descricao;
  }


  @Override
  public String toString() {
    super.toString();
    return super.toString() + " ,descrição do ministério: " + descricao;
  }
}