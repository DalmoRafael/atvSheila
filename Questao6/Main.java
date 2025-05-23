import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Documento> documentos = new LinkedList<>();
        int opc = 0;
        do {
            System.out.println("0. Fechar");
            System.out.println("1. Adicionar documento");
            System.out.println("2. Imprimir o próximo");
            System.out.println("3. Listar documentos");
            System.out.print("Resposta: ");
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    opc = scanner.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Insira somente números");
                    scanner.nextLine();
                    System.out.print("Resposta: ");
                }
            }
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    documentos.add(new Documento(nomeUsuario, nomeArquivo));
                    System.out.println("Novo documento adicionado na fila!");
                    break;
                case 2:
                    char simOuNao;
                    do {
                        if (documentos.peek() == null) {
                            System.out.println("Fila de impressões vazia!");
                            break;
                        }
                        System.out.println("Tem certeza que deseja imprimir \"" + documentos.peek().getNomeArquivo() + "\" de " + documentos.peek().getNomeUsuario() + "?");
                        System.out.print("Resposta [S/N]: ");
                        simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                        if (simOuNao == 'S') {
                            System.out.println("\"" + documentos.poll().getNomeArquivo() + "\" imprimido!");
                        } else if (simOuNao == 'N') {
                            break;
                        } else {
                            System.out.println("Resposta inválida!");
                        }
                    } while (simOuNao != 'S' && simOuNao != 'N');
                    break;
                case 3:
                    if (documentos.isEmpty()) {
                        System.out.println("Fila de impressões vazia!");
                        break;
                    }
                    int contador = 1;
                    System.out.println("------------------------------");
                    System.out.println("----- FILA DE IMPRESSÕES -----");
                    System.out.println("------------------------------");
                    for (Documento d : documentos) {
                        System.out.println(contador + ". " + d);
                        contador++;
                    }
                    System.out.println("------------------------------");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        } while (opc != 0);
        System.out.println("Obrigado por testar! :D");
        scanner.close();
    }
}
