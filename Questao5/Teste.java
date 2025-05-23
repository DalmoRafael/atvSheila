import java.util.*;
public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Paciente> pacientes = new LinkedList<>();
        int opc;
        do {
            System.out.println("0. Fechar");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Atender o próximo");
            System.out.println("3. Ver pacientes na fila");
            System.out.print("Resposta: ");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    String nome, sintoma;
                    System.out.print("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite o sintoma: ");
                    sintoma = scanner.nextLine();
                    pacientes.add(new Paciente(nome, sintoma));
                    System.out.println("Paciente " + nome + " criado!");
                    break;
                case 2:
                    System.out.println("Tem certeza que deseja atender " + pacientes.peek().getNome() + "?");
                    System.out.print("Resposta [S/N]: ");
                    char resp = scanner.nextLine().toUpperCase().charAt(0);
                    if (resp == 'S') {
                        System.out.println(pacientes.peek().getNome() + " atendido!");
                        pacientes.poll();
                    } else {
                        break;
                    }
                    break;
                case 3:
                    if (pacientes.isEmpty()) {
                        System.out.println("Fila vazia!");
                        break;
                    }
                    for (Paciente p : pacientes) {
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opc != 0);
        scanner.close();
    }
}
