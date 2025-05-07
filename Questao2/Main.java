import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        String nomeItem;
        int opc, index;
        do {
            System.out.println("0. Fechar");
            System.out.println("1. Adicionar");
            System.out.println("2. Editar");
            System.out.println("3. Remover");
            System.out.println("4. Listar");
            System.out.print("Resposta: ");
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.print("Insira nome do produto: ");
                    nomeItem = scanner.nextLine();
                    index = produtoExiste(produtos, nomeItem);
                    if (produtos.isEmpty() || index == -1) {
                        produtos.add(new Produto(nomeItem));
                        System.out.println(produtos.getLast().getNome() + " adicionado!");
                    } else {
                        int quant = produtos.get(index).getQuant();
                        produtos.get(index).setQuant(quant + 1);
                        System.out.print("Produto já existente! Quantidade aumentado de " + quant);
                        quant = produtos.get(index).getQuant();
                        System.out.println(" para " + quant);
                    }
                    break;
                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Lista vazia!");
                        break;
                    }
                    do {
                        System.out.print("Digite o nome do produto para editar: ");
                        nomeItem = scanner.nextLine();
                        index = produtoExiste(produtos, nomeItem);
                        if (index == -1) {
                            System.out.println("Esse produto não existe!");
                        }
                    } while (index == -1);
                    int opcAtributo;
                    do {
                        System.out.println("Digite qual atributo editar:");
                        System.out.println("1. Nome");
                        System.out.println("2. Quantidade");
                        System.out.print("Resposta: ");
                        opcAtributo = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcAtributo) {
                            case 1:
                                String nomeAntigo = produtos.get(index).getNome();
                                do {
                                    System.out.println("Nome atual: " + nomeAntigo);
                                    System.out.print("Digite um novo nome: ");
                                    nomeItem = scanner.nextLine();
                                    if (nomeAntigo.equals(nomeItem)) {
                                        System.out.println("O novo nome não pode ter o mesmo nome anterior!");
                                    }
                                } while (nomeAntigo.equals(nomeItem));
                                produtos.get(index).setNome(nomeItem);
                                System.out.println("Nome alterado de " + nomeAntigo + " para " + produtos.get(index).getNome() + "!");
                                break;
                            case 2:
                                int quantAntiga = produtos.get(index).getQuant();
                                System.out.println("Quantidade atual: " + quantAntiga);
                                System.out.print("Insira uma nova quantidade: ");
                                int quantAtual = scanner.nextInt();
                                scanner.nextLine();
                                produtos.get(index).setQuant(quantAtual);
                                if (quantAtual != quantAntiga) {
                                    System.out.println("Quantidade alterada de " + quantAntiga + " para " + produtos.get(index).getQuant() + "!");
                                } else {
                                    System.out.println("A quantidade se manteve o mesmo!");
                                }
                                break;
                            default:
                                System.out.println("Insira uma opção válida!");
                        }
                    } while (opcAtributo < 1 || opcAtributo > 2);
                    break;
                case 3:
                    if (produtos.isEmpty()) {
                        System.out.println("Lista vazia!");
                        break;
                    }
                    String produtoRemover;
                    do {
                        System.out.print("Insira o nome do produto para remover: ");
                        produtoRemover = scanner.nextLine();
                        index = produtoExiste(produtos, produtoRemover);
                        if (index == -1) {
                            System.out.println("O produto não existe! Tente novamente!");
                        }
                    } while (index == -1);
                    String produtoRemovido = produtos.get(index).getNome();
                    produtos.remove(index);
                    System.out.println(produtoRemovido + " removido!");
                    break;
                case 4:
                    if (produtos.isEmpty()) {
                        System.out.println("Lista vazia!");
                        break;
                    }

                    System.out.println(" Nome  | Quantidade ");
                    System.out.println("--------------------");
                    for (Produto p : produtos) {
                        System.out.println(p.getNome() + " | " + p.getQuant());
                    }
                    System.out.println("--------------------");
                    break;
                default:
                    System.out.println("Insira uma opção válida!");

            }
        } while (opc != 0);
        System.out.println("Obrigado por testar! 😊");
        scanner.close();
    }

    public static int produtoExiste(List<Produto> produtos, String produtoAProcurar) {
        int indice = 0;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(produtoAProcurar)) return indice;
            indice++;
        }
        return -1;
    }
}
