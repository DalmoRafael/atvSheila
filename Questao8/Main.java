import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navegador navegador = new Navegador();
        String pagina;
        int opc = 0;
        do {
            System.out.print("Página atual: ");
            if (navegador.paginaAtual.isEmpty()) {
                System.out.println("Guia vazia");
            } else {
                System.out.println(navegador.paginaAtual.peek());
            }
            System.out.println("0. Fechar");
            System.out.println("1. Visitar site");
            System.out.println("2. Retroceder");
            System.out.println("3. Avançar");
            System.out.println("4. Histórico");
            System.out.print("Insira uma opção: ");
            boolean isValido = false;
            while (!isValido) {
                try {
                    opc = scanner.nextInt();
                    isValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Somente números!");
                    scanner.nextLine();
                    System.out.print("Insira uma opção: ");
                }
            }
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Insira o site para visitar: ");
                    pagina = scanner.nextLine();
                    if (!navegador.paginaAtual.isEmpty()) navegador.pilhaRetroceder.push(navegador.paginaAtual.pop());
                    navegador.paginaAtual.push(pagina);
                    break;
                case 2:
                    if (navegador.pilhaRetroceder.isEmpty()) {
                        System.out.println("Não há páginas para retroceder!");
                        break;
                    }
                    navegador.retroceder();
                    break;
                case 3:
                    if (navegador.pilhaAvancar.isEmpty()) {
                        System.out.println("Não há páginas para avançar!");
                        break;
                    }
                    navegador.avancar();
                    break;
                case 4:
                    if (navegador.pilhaRetroceder.isEmpty()) {
                        System.out.println("Não existe páginas visitadas!");
                        break;
                    }
                    navegador.exibirHistorico();
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        } while (opc != 0);
        scanner.close();
    }
}
