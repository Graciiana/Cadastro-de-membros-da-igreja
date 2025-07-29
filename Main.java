
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
                    teclado.nextLine();
                    Utilitarios.limpar();
                    break;
                case 2:
                    Utilitarios.ministeriosIgreja();
                    Utilitarios.limpar();
                    break;
                case 3:
                    Utilitarios.lista_Memboros();
                    
                    break;

                case 0:
                    cadastro = false;
                    break;
            }
        }
    }

}
