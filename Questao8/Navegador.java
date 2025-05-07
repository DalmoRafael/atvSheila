import java.util.Stack;

public class Navegador {
    Stack<String> pilhaRetroceder = new Stack<>();
    Stack<String> paginaAtual = new Stack<>();
    Stack<String> pilhaAvancar = new Stack<>();

    public void retroceder() {
        System.out.println("Voltando para \"" + pilhaRetroceder.peek() + "\"");
        pilhaAvancar.push(paginaAtual.pop());
        paginaAtual.push(pilhaRetroceder.pop());
    }

    public void avancar() {
        System.out.println("Avançando para \"" + pilhaAvancar.peek() + "\"");
        pilhaRetroceder.push(paginaAtual.pop());
        paginaAtual.push(pilhaAvancar.pop());
    }

    public void exibirHistorico() {
        for (String a : pilhaRetroceder) {
            System.out.println(a);
        }

        for (String b : paginaAtual) {
            System.out.println(b);
        }

        for (String c: pilhaAvancar) {
            System.out.println(c);
        }
    }
}
