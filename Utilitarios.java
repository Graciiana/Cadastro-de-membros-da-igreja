import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilitarios {
    static String nomeMinisterio, descricaoMininsterio;
    static Scanner teclado = new Scanner(System.in);
    static List<Membros> membros = new ArrayList<>();
    static List<Ministerios> ministerios = new ArrayList<>();
    static String nome, cargo;
    static boolean encontrado = false;

    // Método para o cadastro de Membros
    public static void cadastraMembros() {
        System.out.println("______Menu Cadastro_______");
        teclado.nextLine();
        String[] cargos = { "Cantor", "Cantora", "Intercessor", "protocolo" };
        System.out.print("Digite o número de pessoas a cadastrar: ");
        int quantidade = teclado.nextInt();
        teclado.nextLine();
        limpar();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print(i + "ª" + " Membro: ");
            nome = teclado.nextLine();

            do {
                System.out.print("Cargo: ");
                cargo = teclado.nextLine();

                for (String cadastroPermitido : cargos) {
                    if (cadastroPermitido.equalsIgnoreCase(cargo)) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Cargo inválido. Tente novamente. (Ex: Cantor, Intercessor, protocolo)");
                }
            } while (!encontrado);
            // Instanciar membro e adicionar no ArrayList
            Membros cadastro = new Membros(nome, cargo);
            membros.add(cadastro);
        }

        salvarMembrosEmArquivo();
        System.out.println("Dados cadastrados com sucesso");

        System.out.println("Queres continuar fazendo o cadastro?, digite Sim/Não.");
        String continuar = teclado.nextLine();
        System.out.println("Deia enter para continuar.");

        if (continuar.equalsIgnoreCase("Sim")) {
            teclado.nextLine();
            // limpar();
            cadastraMembros();
        } else {
            System.out.println("Cadastro terminado");
        }
    }

    // Método para o cadastro de Ministerios
    public static void ministeriosIgreja() {
        System.out.println("------ Menu Ministerios----------");

        for (int i = 1; i <= 2; i++) {
            System.out.print(i + " º " + "Ministério: ");
            nomeMinisterio = teclado.nextLine();
            System.out.print("Descrição: ");
            descricaoMininsterio = teclado.nextLine();

            // Instanciando a Classe Ministerios
            Ministerios min = new Ministerios(nomeMinisterio, descricaoMininsterio);
            ministerios.add(min);
        }
        salvarMinisteriosEmArquivo();
        System.out.println("Cadasto feito com sucesso");
        teclado.nextLine();
    }

    // Metódos para listar os dados do ministerio e dos membros

    public static void lista_Membros() {
        teclado.nextLine();
        System.out.println("------ Lista dos membros--------");
        for (Membros listaMem : membros) {
            System.out.println(listaMem);
        }
        System.out.println("_______________________________________");
        // Pesquisa
        System.out.println("Deseja fazer uma pesquisa por data? Sim/Não ");
        String pesquisa = teclado.nextLine();
        if (pesquisa.equalsIgnoreCase("Sim")) {
            System.out.println("Digite uma data no formato AAA-MM-DD:  ");
            String dataString = teclado.nextLine();

            try {
                LocalDate dataPesquisa = LocalDate.parse(dataString);

                System.out.println("------- Membros com data: " + dataPesquisa + " ----------\n");
                boolean encontrou = false;

                for (Membros membros2 : membros) {

                    // Compara a data do sistema com a data digitada pelo usuario
                    if (membros2.getDataCadastro().equals(dataPesquisa)) {
                        System.out.println(membros2);
                        encontrou = true;
                    }
                }
                if (!encontrou) {
                    System.out.println("Nenhum membro encontrado nessa data.");
                }

            } catch (Exception e) {
                System.out.println("Data inválida. Use o formato AAAA-MM-DD.");
            }
        }
    }

    // Ministerios
    public static void lista_Ministerios() {
        teclado.nextLine();
        System.out.println("------ Lista dos Ministerios--------");
        for (Ministerios listaMin : ministerios) {
            System.out.println(listaMin);
        }
        System.out.println("________________________________________________________________________");

        // Pesquisa
        System.out.println("Deseja fazer alguma operação? digite (0)eliminar/(1)pesquisar/(2)editar");
        int pesquisa = teclado.nextInt();
        teclado.nextLine();

        if (pesquisa == 1) {

            System.out.println("Digite uma data no formato AAA-MM-DD:  ");
            String dataString = teclado.nextLine();

            try {
                LocalDate dataPesquisa = LocalDate.parse(dataString);

                System.out.println("------- Ministerios com data: " + dataPesquisa + " ----------\n");
                boolean encontrou = false;

                for (Ministerios mini : ministerios) {

                    // Compara a data do sistema com a data digitada pelo usuario
                    if (mini.getDataCadastro().equals(dataPesquisa)) {
                        System.out.println(mini);
                        encontrou = true;
                    }
                }
                if (!encontrou) {
                    System.out.println("Nenhum ministerio encontrado nessa data.");
                }

            } catch (Exception e) {
                System.out.println("Data inválida. Use o formato AAAA-MM-DD.");
            }
        }
        // Eliminar
        else if (pesquisa == 0) {
            teclado.nextLine();
            System.out.println("_______________________________________");

            System.out.print("Digite um nome a eliminar: ");
            String nomeEliminar = teclado.nextLine();

            Ministerios ministerioParaRemover = null;
            for (Ministerios minis : ministerios) {
                if (minis.getNome().equalsIgnoreCase(nomeEliminar)) {
                    ministerioParaRemover = minis;
                    break;
                }
            }

            if (ministerioParaRemover != null) {
                ministerios.remove(ministerioParaRemover);
                salvarMinisteriosEmArquivo();
                System.out.println("Ministério removido com sucesso.");
            } else {
                System.out.println("Ministério não encontrado.");
            }
        }
        // Editar
        else if (pesquisa == 2) {
            System.out.println("_____________________________________");
            System.out.print("Escolha o nome do ministerio que queres mudar: ");
            String nome_a_mudar = teclado.nextLine();

            boolean nomeEncntrado = false;

            for (Ministerios mini2 : ministerios) {
                if (mini2.getNome().equalsIgnoreCase(nome_a_mudar)) {
                    System.out.print("Digite um novo nome: ");
                    String novoNome = teclado.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = teclado.nextLine();

                    mini2.setNome(novoNome);
                    mini2.setDescricao(descricao);
                    // Adicionando na lista
                    System.out.println("Dados editados com sucesso");
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }

                    System.out.println("Dados editados: \n" + mini2);
                    salvarMembrosEmArquivo();

                    nomeEncntrado = true;
                    break;
                }
            }
            if (!nomeEncntrado) {
                System.out.println("Nome não encontrado.");
            }
        } else {
            System.out.println("Opção inválida");
        }
    }

    // Salvar membros
    public static void salvarMembrosEmArquivo() {
        try (PrintWriter writer = new PrintWriter("membros.txt")) {
            for (Membros m : membros) {
                writer.println(m.getNome() + ";" + m.getCargo() + ";" + m.getDataCadastro());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar membros: " + e.getMessage());
        }
    }

    // Carregar membros
    public static void carregarMembrosDoArquivo() {
        membros.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("membros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Membros membro = new Membros(partes[0], partes[1]);
                    membro.setDataCadastro(LocalDate.parse(partes[2]));
                    membros.add(membro);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar membros: " + e.getMessage());
        }
    }

    // Salvar ministerios
    public static void salvarMinisteriosEmArquivo() {
        try (PrintWriter writer = new PrintWriter("ministerios.txt")) {
            for (Ministerios m : ministerios) {
                writer.println(m.getNome() + ";" + m.getDescricao() + ";" + m.getDataCadastro());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar ministerios: " + e.getMessage());
        }
    }

    // Carregar ministerios
    public static void carregarMinisteriosDoArquivo() {
        ministerios.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("ministerios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Ministerios minist = new Ministerios(partes[0], partes[1]);
                    minist.setDataCadastro(LocalDate.parse(partes[2]));
                    ministerios.add(minist);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar ministerios: " + e.getMessage());
        }
    }

    // Método para limpeza dos dados digitados"

    public static void limpar() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
