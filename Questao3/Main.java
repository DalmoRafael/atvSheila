import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> acoes = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opc;
        do {
            System.out.println("0. Fechar");
            System.out.println("1. Executar ação");
            System.out.println("2. Desfazer ação");
            System.out.println("3. Listar ações");
            System.out.print("Resposta: ");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Insira uma ação: ");
                    String acao = scanner.nextLine();
                    acoes.push(acao);
                    System.out.println("A ação \'" + acoes.peek() + "\' foi adicionada!");
                    break;
                case 2:
                    if (acoes.isEmpty()) {
                        System.out.println("Pilha vazia! Adicione alguma ação!");
                        break;
                    }
                    char simOuNao;
                    do {
                        System.out.println("Tem certeza que quer desfazer a ação \'" + acoes.peek() + "\'?");
                        System.out.print("Resposta [S/N]: ");
                        simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                        if (simOuNao == 'S') {
                            System.out.println("\'" + acoes.pop() + "\' desfeita!");
                        } else if (simOuNao == 'N') {
                            break;
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    } while (simOuNao != 'S' && simOuNao != 'N');
                    break;
                case 3:
                    if (acoes.isEmpty()) {
                        System.out.println("Pilha vazia! Adicione alguma ação!");
                        break;
                    }
                    System.out.println("--------------------");
                    for (String s : acoes) {
                        System.out.println(s);
                    }
                    System.out.println("--------------------");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        } while (opc != 0);
        System.out.println("Valeu!");
        scanner.close();

    }
}
