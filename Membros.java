public class Membros extends Cadastro{
  private String cargo;

  Membros(String nome, String cargo){
      super(nome);
      this.cargo=cargo;
  }

  public String getCargo(){
    return cargo;
  }
  @Override
    public String toString(){
      super.toString();
    return super.toString()+ " ,cargo: "+cargo;
    }
}