package hospital;
import java.util.Scanner;
public class Hospital {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            menuOpcoes(scanner);

            System.out.print("\nDeseja finalizar o programa? (s/n): ");
        } while (scanner.nextLine().equalsIgnoreCase("n"));


    }

    private static void menuOpcoes(Scanner scanner) {
        System.out.println("Escolha uma opcao:");
        System.out.println("1. Cadastrar novo paciente");
        System.out.println("2. Pesquisar paciente pelo ID");
        System.out.println("3. Deletar paciente pelo ID");
        System.out.println("4. Atualizar dados do paciente pelo ID");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Não tira isso faz ler primeiro o nome e dps a altura se não buga...

        switch (opcao) {
            case 1:
                Paciente.cadastrarPacientes(scanner);
                Paciente.exibirPacientes();
                break;
            case 2:
                System.out.print("Informe o ID do paciente que deseja pesquisar: ");
                int idPesquisar = scanner.nextInt();
                 scanner.nextLine();
                pesquisarPacientePorId(idPesquisar);
                break;
            case 3:
                System.out.print("Informe o ID do paciente que deseja deletar: ");
                int idRemover = scanner.nextInt();
                scanner.nextLine();
                Paciente.removerPorId(idRemover);
                System.out.println("\nPacientes apos a remocao:");
                Paciente.exibirPacientes();
                break;

            case 4:
                System.out.print("Informe o ID do paciente que deseja atualizar: ");
                int idAtualizar = scanner.nextInt();
                 scanner.nextLine();
                atualizarDadosPacientePorId(idAtualizar, scanner);
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    public static void cadastrarPacientes(Scanner scanner){
        Paciente.cadastrarPacientes(scanner);
    }
    public static void pesquisarPacientePorId(int id) {
// Método para pesquisar paciente por ID
        Paciente.exibirPacientePorId(id);
    }

    private static void atualizarDadosPacientePorId(int id, Scanner scanner) {
// Método para atualizar dados do paciente por ID
        Paciente.atualizarPacientePorId(id, scanner);
    }
}