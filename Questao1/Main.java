import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tarefa> tarefas = new ArrayList<>();
        int opc, index;
        do {
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Mostrar tarefas");
            System.out.println("3. Editar tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Mover tarefa");
            System.out.print("Resposta: ");
            opc = scanner.nextInt();
            div();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    tarefas.add(new Tarefa(scanner.nextLine()));
                    System.out.println("Tarefa criada!");
                    div();
                    break;
                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                        div();
                        break;
                    }
                    System.out.println("Tarefas: ");
                    listarTarefas(tarefas);
                    div();
                    break;
                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                        div();
                        break;
                    }
                    String tarefaAEditar;
                    do {
                        System.out.print("Digite o nome da tarefa para editar: ");
                        tarefaAEditar = scanner.nextLine();
                        index = tarefaExiste(tarefas, tarefaAEditar);
                        if (index == -1) {
                            System.out.println("Tarefa não existe!");
                        }
                    } while (index == -1);
                    String novaTarefa, tarefaAnterior;
                    do {
                        tarefaAnterior = tarefas.get(index).getNome();
                        System.out.print("Digite o novo nome da tarefa: ");
                        novaTarefa = scanner.nextLine();
                        if (novaTarefa.equals(tarefaAnterior)) {
                            System.out.println("A nova tarefa não pode ser a mesma de antes!");
                        } else {
                            tarefas.get(index).setNome(novaTarefa);
                        }
                    } while (novaTarefa.equals(tarefaAnterior));
                    System.out.println("Tarefa editada!");
                    div();
                    break;
                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                        div();
                        break;
                    }
                    String tarefaARemover;
                    do {
                        System.out.print("Digite o nome da tarefa para remover: ");
                        tarefaARemover = scanner.nextLine();
                        index = tarefaExiste(tarefas, tarefaARemover);
                        if (index == -1) {
                            System.out.println("Tarefa não existe!");
                        }
                    } while (index == -1);
                    tarefas.remove(index);
                    System.out.println("Tarefa removida!");
                    div();
                    break;
                case 5:
                    if (tarefas.isEmpty()) {
                        System.out.println("Lista vazia!");
                        div();
                        break;
                    }
                    String tarefasASeremTrocadas;
                    int indexTarefa1, indexTarefa2 = 0;
                    do {
                        System.out.print("Digite o nome de 2 tarefas para trocar: ");
                        tarefasASeremTrocadas = scanner.nextLine();
                        indexTarefa1 = tarefaExiste(tarefas, tarefasASeremTrocadas);
                        if (indexTarefa1 == -1) {
                            System.out.println("A 1° tarefa não existe! Tente novamente!");
                            continue;
                        }
                        tarefasASeremTrocadas = scanner.nextLine();
                        indexTarefa2 = tarefaExiste(tarefas, tarefasASeremTrocadas);
                        if (indexTarefa2 == -1) {
                            System.out.println("A 2° tarefa não existe! Tente novamente!");
                        }
                    } while (indexTarefa1 == -1 || indexTarefa2 == -1);
                    Collections.swap(tarefas, indexTarefa1, indexTarefa2);
                    System.out.println("Tarefas trocadas de lugar!");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");

            }
        } while (opc != 0);
        scanner.close();
    }

    public static void listarTarefas(List<Tarefa> tarefas) {
        for (Tarefa t : tarefas) {
            System.out.println(t.getNome());
        }
    }

    public static int tarefaExiste(List<Tarefa> tarefas, String tarefaAProcurar) {
        int indice = 0;
        for (Tarefa t : tarefas) {
            if (t.getNome().equalsIgnoreCase(tarefaAProcurar)) return indice;
            indice++;
        }
        return -1;
    }

    public static void div() {
        System.out.println("--------------------------------------");
    }
}
