
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Iniciando o carregamento dos membros cadastrados
        Utilitarios.carregarMembrosDoArquivo();
        Utilitarios.carregarMinisteriosDoArquivo();
        Utilitarios.limpar();

        boolean cadastro = true;
        Scanner teclado = new Scanner(System.in);

        while (cadastro) {
            System.out.println("Escolha uma opção: ");
            System.out.println("_____________________________________");

            System.out.println("[0]- Sair");
            System.out.println("[1]- Cadastro de Membros");
            System.out.println("[2]- Cadastro de Ministerios");
            System.out.println("[3]- Listas de Membros");
            System.out.println("[4]- Listas de Ministerios");

            int opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    Utilitarios.cadastraMembros();
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    //Utilitarios.limpar();
                    break;
                case 2:
                    Utilitarios.ministeriosIgreja();
                    Utilitarios.limpar();
                    break;
                case 3:
                    Utilitarios.lista_Membros();
                    teclado.nextLine();
                    Utilitarios.limpar();
                    break;
                case 4:
                    Utilitarios.lista_Ministerios();
                    Utilitarios.limpar();
                    break;
                case 0:
                    cadastro = false;
                    teclado.nextLine();
                    Utilitarios.limpar();
                    break;    
            }
        }
    }
}
