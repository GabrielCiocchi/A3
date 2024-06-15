
package hospital;
import java.util.Scanner;

public class Paciente {
    private static Paciente[] pacientes = new Paciente[2]; // começa com 2
    private static int totalPacientes = 0;
    private static int proximoId = 1;

    private int id;
    private String nome;
    private float altura;
    private String situacao;
    private float peso;
    private float imc;

    private Paciente(String nome, float altura, String situacao, float peso, float imc) {
        this.id = proximoId++;
        this.nome = nome;
        this.altura = altura;
        this.situacao = situacao;
        this.peso = peso;
        this.imc = imc;
    }
    public static void getPaciente(String nome, float altura, String situacao, float peso, float imc) {
        if (totalPacientes == pacientes.length) {
            redimensionarVetor();
        }
        pacientes[totalPacientes++] = new Paciente(nome, altura, situacao, peso, imc);
    }
    public static void exibirPacientes() {
        for (int i = 0; i < totalPacientes; i++) {
            pacientes[i].getInfo();
        }
    }
    public static void exibirPacientePorId(int id) {
        for (int i = 0; i < totalPacientes; i++) {
            if (pacientes[i].getId() == id) {
                pacientes[i].getInfo();
                return;
            }
        }
        System.out.println("Paciente com ID " + id + " não encontrado.");
    }
    public static void removerPorId(int id) {
        boolean encontrado = false;
        for (int i = 0; i < totalPacientes; i++) {
            if (pacientes[i].getId() == id) { 
                for (int j = i; j < totalPacientes - 1; j++) {
                    pacientes[j] = pacientes[j + 1];
                }
                pacientes[--totalPacientes] = null; // limpa a última posição do vetor
                encontrado = true;
                System.out.println("Paciente removido com sucesso.");
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("Paciente com ID " + id + " nao encontrado.");
        }
    }
    public static void cadastrarPacientes(Scanner scanner) {
// LOOP pra cadastrar os pacientes
        while (true) {
            System.out.println("Cadastro do Paciente:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Altura (m): ");
            float altura = scanner.nextFloat();
             scanner.nextLine();

            System.out.print("Peso: ");
            float peso = scanner.nextFloat();
             scanner.nextLine();
            
// CONTA IMC
            String situacao;
            float imc = peso/ (altura*altura);
             if (imc < 18.5) {
             situacao = "Baixo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            situacao = "Peso normal";            
        } else if (imc >= 25 && imc < 29.9) {
            situacao = "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {  
            situacao = "Obesidade I";
        } else if (imc >= 35 && imc < 39.9) {  
            situacao = "Obesidade II";
        } else {
            situacao = "Obesidade III";
        }

            
            Paciente.getPaciente(nome, altura, situacao, peso, imc);

            System.out.print("Deseja cadastrar mais um paciente? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }

    }
    public static void atualizarPacientePorId(int id, Scanner scanner) {
        for (int i = 0; i < totalPacientes; i++) {
            if (pacientes[i].getId() == id) {
                System.out.print("Novo Nome: ");
                pacientes[i].nome = scanner.nextLine();

                System.out.print("Nova Altura (m): ");
                pacientes[i].altura = scanner.nextFloat();
                scanner.nextLine(); 
                
                System.out.print("Novo Peso: ");
                pacientes[i].peso = scanner.nextFloat();
                scanner.nextLine(); 
                
// Recálculo do IMC e determinação da situação
                float imc = pacientes[i].peso / (pacientes[i].altura * pacientes[i].altura);
                if (imc < 18.5) {
                    pacientes[i].situacao = "Baixo peso";
                } else if (imc >= 18.5 && imc < 24.9) {
                    pacientes[i].situacao = "Peso normal";            
                } else if (imc >= 25 && imc < 29.9) {
                    pacientes[i].situacao = "Sobrepeso";
                } else if (imc >= 30 && imc < 34.9) {  
                    pacientes[i].situacao = "Obesidade I";
                } else if (imc >= 35 && imc < 39.9) {  
                    pacientes[i].situacao = "Obesidade II";
                } else {
                    pacientes[i].situacao = "Obesidade III";
                }

                pacientes[i].imc = imc;

                System.out.println("Dados do paciente atualizados com sucesso.");
                return;
            }
        }
        System.out.println("Paciente com ID " + id + " nao encontrado.");
    }
    private static void redimensionarVetor() {
        int novoTamanho = pacientes.length * 2;
        Paciente[] novoVetor = new Paciente[novoTamanho];
        System.arraycopy(pacientes, 0, novoVetor, 0, pacientes.length);
        pacientes = novoVetor;
    }
    public int getId() {
        return id;
    }
    public void getInfo() {
        System.out.println("ID: " + id + ". Nome: " + nome + "\n Altura (cm): " + altura + "\n Situacao: " + situacao + "\n Peso: " + peso + "\n IMC: " + imc);
    }
}