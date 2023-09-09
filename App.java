package JAVA.AtividadeBancoDeDados;
import java.util.Stack;
import java.util.Scanner;

class Cadastro {
    private String nome;
    private int idade;

    public Cadastro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}

class CadastroF {
    private Stack<Cadastro> pCadastro = new Stack<>();

    public void cadastrar(String nome, int idade) {
        Cadastro novoCadastro = new Cadastro(nome, idade);
        pCadastro.push(novoCadastro);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public void listarCadastros() {
        if (pCadastro.isEmpty()) {
            System.out.println("Não há cadastros disponíveis.");
        } else {
            System.out.println("Lista de Cadastros:");
            for (Cadastro cadastro : pCadastro) {
                System.out.println(cadastro);
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroF criar = new CadastroF();

        while (true) {
            System.out.println("\nDigite um numero para: ");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar Cadastros");
            System.out.println("3. Finalizar o Programa\n");

            System.out.print("Função escolhida: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer 

            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer 

                    criar.cadastrar(nome, idade);
                    break;
                case 2:
                    criar.listarCadastros();
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
