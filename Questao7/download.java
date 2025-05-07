import java.util.*;

public class download {
    public static void main(String[] args) {
        int opc;
        char confirmacao;
        String arquivo;
        Scanner scanner = new Scanner(System.in);
        List<String> Pendente = new ArrayList<>();
        Queue<String> emAndamento = new LinkedList<>();
            do {

                System.out.println("0. Fechar");
                System.out.println("1. Adicionar");
                System.out.println("2. Concluir downloads");
                System.out.println("3. Listar");
                System.out.print("Digite sua escolha: ");
                opc = scanner.nextInt();
                scanner.nextLine();

                switch (opc){
                    case 1:
                        do {
                            System.out.print("Digite seu arquivo: ");
                            arquivo = scanner.nextLine();
                            Pendente.add(arquivo);
                            System.out.println("Deseja adicionar algo mais? [S/N]");
                            confirmacao = scanner.nextLine().toUpperCase().charAt(0);
                            if (confirmacao == 'S'){
                                continue;
                            }
                            else if(confirmacao == 'N'){
                                break;
                            }else {
                                System.out.println("Apenas S ou N!!!!!!!!!!!!!!!! ");
                            }
                        }while (confirmacao == 'S');
                        if (Pendente.size() <= 3) {
                            while (!Pendente.isEmpty() ){
                                emAndamento.add(Pendente.removeFirst());
                            }

                        }
                            else {
                                for (int i = 0; i < 3; i++) {
                                    emAndamento.add(Pendente.removeFirst());
                                }
                            }
                        System.out.println("_________________________________________");
                        break;
                    case 2:
                        System.out.println("_________________________________________");
                        if (emAndamento.isEmpty()){
                            System.out.println("A fila esta vazia.");
                            break;
                        }
                        while (!emAndamento.isEmpty()){
                            System.out.println("Download do\"" + emAndamento.poll() + "\"está concluido");
                        }
                        System.out.println("_________________________________________");
                        if (Pendente.size() <= 3) {
                            while (!Pendente.isEmpty() ){
                                emAndamento.add(Pendente.removeFirst());
                            }

                        }
                        else {
                            for (int i = 0; i < 3; i++) {
                                emAndamento.add(Pendente.removeFirst());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("_______________Em Andamento______________");
                        for (String l : emAndamento) {
                            System.out.println(l == null ? "lista vazia": l);
                        }
                        System.out.println("_________________________________________");
                        System.out.println("______________ Pendentes ________________");
                        for (String l : Pendente) {
                            System.out.println(l == null ? "lista vazia": l);
                        }
                        System.out.println("_________________________________________");

                        break;
            }


    }while (opc != 0);
    }
}
