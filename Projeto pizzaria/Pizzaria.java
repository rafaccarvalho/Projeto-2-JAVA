
import java.util.ArrayList;
import java.util.Scanner;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando funcionarios
        ArrayList<Atendente> atendentes = new ArrayList<>();
        atendentes.add(new Atendente("João Da Silva", 123456));
        atendentes.add(new Atendente("Maria Oliveira", 789012));
        atendentes.add(new Atendente("Lucas Carvalho", 345678));
        Caixa caixa = new Caixa("Marcelo Campos", 901234);
        Gerente gerente = new Gerente("Luiza Costa", "1234", 385474);

        // Criando mesas
        ArrayList<Mesa> mesas = new ArrayList<>();
        mesas.add(new Mesa(1, 2));
        mesas.add(new Mesa(2, 2));
        mesas.add(new Mesa(3, 4));
        mesas.add(new Mesa(4, 4));
        mesas.add(new Mesa(5, 10));

        // Lista para armazenar os clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        System.out.println("BEM VINDO A PIZZARIA CHE BELLA PIZZA!");

        // Menu
        int opcao = 0;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar chegada de cliente e quantidade de lugares solicitados");
            System.out.println("2. Alocar cliente em mesa");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. Listar funcionários");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do representante: ");
                    String nomeRepresentante = scanner.nextLine();
                    System.out.print("Quantidade de lugares solicitados: ");
                    int quantidadeLugares = scanner.nextInt();

                    Cliente novoCliente = new Cliente(nomeRepresentante, quantidadeLugares);
                    clientes.add(novoCliente);

                    System.out.println("Grupo registrado com sucesso!");
                    break;

                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente registrado. Primeiramente, registre a chegada de um grupo.");
                        break;
                    }
                
                    System.out.print("Digite o nome do representante do grupo a ser alocado: ");
                    String nomeRepresentanteAlocacao = scanner.nextLine();
                
                    Cliente clienteAlocar = null;
                    for (Cliente c : clientes) {
                        if (c.getNomeRepresentante().equalsIgnoreCase(nomeRepresentanteAlocacao)) {
                            clienteAlocar = c;
                            break;
                        }
                    }
                
                    if (clienteAlocar == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                
                    int quantidadeClientes = clienteAlocar.getQuantidadePessoas();
                
                    Mesa mesaAlocada = Mesa.alocarMesa(mesas, quantidadeClientes);
                
                    if (mesaAlocada != null) {
                        System.out.println("Mesa " + mesaAlocada.getNumero() + " alocada para o grupo de " + quantidadeClientes + " pessoas.");
                    } else {
                        System.out.println("Não há mesas disponíveis para esse grupo.");
                    }
                
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    System.out.println("Lista de funcionários: ");
                    for (Atendente a : atendentes) {
                        a.exibirFuncionario();
                    }
                    caixa.exibirFuncionario();
                    gerente.exibirFuncionario();
                    break;

                case 7:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }
}           