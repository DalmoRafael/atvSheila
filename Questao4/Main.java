import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();
        String expressao;
        boolean expressaoValida = true;
        do {
            System.out.println("Digite 0 para fechar");
            System.out.print("Insira uma expressão: ");
            expressao = scanner.nextLine().trim();
            char[] expressaoCharArray = expressao.toCharArray();
            for (Character c : expressaoCharArray) {
                if (c == '(' || c == '[' || c == '{') pilha.push(c);
                else if (c == ')' || c == ']' || c == '}') {
                    if (pilha.isEmpty()) {
                        expressaoValida = false;
                        break;
                    }
                    char top = pilha.pop();
                    if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                        expressaoValida = false;
                        break;
                    }
                }
            }

            if (!pilha.isEmpty()) expressaoValida = false;

            if (!expressao.equals("0")) System.out.println(expressaoValida ? "Expressão válida!" : "Expressão inválida!");
            System.out.println("-------------------------------");

        } while (!expressao.equals("0"));
        scanner.close();
    }
}
