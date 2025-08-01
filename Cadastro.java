import java.time.LocalDate;

public class Cadastro{
  private String nome;
  private LocalDate dataCadastro;

  Cadastro(String nome){
    this.nome=nome;
    this.dataCadastro=LocalDate.now();
  }

  public String getNome(){
    return nome;
  }

   public LocalDate getDataCadastro(){
    return dataCadastro;
  }

  public void setDataCadastro(LocalDate data){
    this.dataCadastro=data;
  }

   public void setNome(String nome){
    this.nome=nome;
  }
  
  public String toString(){
    return "Nome: "+nome+" , Data de criação: "+dataCadastro;
  }
}