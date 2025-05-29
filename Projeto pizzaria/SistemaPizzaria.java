//Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPizzaria {
    private ArrayList<Atendente> atendentes;
    private Caixa caixa;
    private Gerente gerente;
    private ArrayList<Mesa> mesas;
    private ArrayList<Cliente> clientes;
    private double faturamentoTotal;

    public SistemaPizzaria() {
        atendentes = new ArrayList<>();
        atendentes.add(new Atendente("João Da Silva", 123456));
        atendentes.add(new Atendente("Maria Oliveira", 789012));
        atendentes.add(new Atendente("Lucas Carvalho", 345678));

        caixa = new Caixa("Marcelo Campos", 901234);
        gerente = new Gerente("Luiza Costa", "1234", 385474);

        mesas = new ArrayList<>();
        mesas.add(new Mesa(1, 2));
        mesas.add(new Mesa(2, 2));
        mesas.add(new Mesa(3, 4));
        mesas.add(new Mesa(4, 4));
        mesas.add(new Mesa(5, 10));

        clientes = new ArrayList<>();
        faturamentoTotal = 0;
    }

    public void registrarChegada(Scanner scanner) {
        System.out.print("Digite o nome do representante: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade de lugares solicitados: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nome, qtd);
        clientes.add(cliente);
        System.out.println("Grupo registrado com sucesso!");
    }

    public void alocarCliente(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente registrado.");
            return;
        }

        System.out.print("Nome do representante a ser alocado: ");
        String nome = scanner.nextLine();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNomeRepresentante().equalsIgnoreCase(nome)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Mesa mesa = Mesa.alocarMesa(mesas, cliente.getQuantidadePessoas());
        if (mesa != null) {
            mesa.setCliente(cliente);
            System.out.println("Mesa " + mesa.getNumero() + " alocada para " + cliente.getQuantidadePessoas() + " pessoas.");
        } else {
            System.out.println("Não há mesas disponíveis.");
        }
    }

    public void anotarPedido(Scanner scanner) {
        System.out.print("Número da mesa: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = buscarMesa(numero);
        if (mesa == null || !mesa.isOcupada()) {
            System.out.println("Mesa inválida ou desocupada.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Pizza 4 queijos (R$100)");
            System.out.println("2. Pizza muçarela (R$60)");
            System.out.println("3. Pizza portuguesa (R$80)");
            System.out.println("4. Água com gás (R$15)");
            System.out.println("5. Água sem gás (R$15)");
            System.out.println("6. Suco de limão (R$20)");
            System.out.println("7. Suco de laranja (R$25)");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            String desc = "";
            double preco = 0;

            switch (opcao) {
                case 1:
                    desc = "Pizza 4 queijos";
                    preco = 100;
                    break;
                case 2:
                    desc = "Pizza muçarela";
                    preco = 60;
                    break;
                case 3:
                    desc = "Pizza portuguesa";
                    preco = 80;
                    break;
                case 4:
                    desc = "Água com gás";
                    preco = 15;
                    break;
                case 5:
                    desc = "Água sem gás";
                    preco = 15;
                    break;
                case 6:
                    desc = "Suco de limão";
                    preco = 20;
                    break;
                case 7:
                    desc = "Suco de laranja";
                    preco = 25;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }

            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            Pedido pedido = new Pedido(desc, qtd, preco);
            mesa.adicionarPedido(pedido);

            System.out.print("Adicionar mais itens? (s/n): ");
            continuar = scanner.nextLine().equalsIgnoreCase("s");
        }

        System.out.println("Pedido registrado.");
    }

    public void gerarConta(Scanner scanner) {
        System.out.print("Número da mesa: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Mesa mesa = buscarMesa(numero);
        if (mesa == null || !mesa.isOcupada() || mesa.getPedidos().isEmpty()) {
            System.out.println("Mesa inválida ou sem pedidos.");
            return;
        }

        Cliente cliente = mesa.getCliente();
        System.out.println("--- CONTA ---");
        System.out.println("Mesa: " + mesa.getNumero());
        System.out.println("Cliente: " + cliente.getNomeRepresentante());
        System.out.println("Pessoas: " + cliente.getQuantidadePessoas());

        double total = 0;
        for (Pedido p : mesa.getPedidos()) {
            p.exibirPedido();
            total += p.calcularTotal();
        }

        System.out.printf("Total: R$ %.2f\n", total);
        System.out.printf("Por pessoa: R$ %.2f\n", total / cliente.getQuantidadePessoas());

        faturamentoTotal += total;
        mesa.liberar();
        System.out.println("Mesa liberada.");
    }

    public void gerarFaturamento(Scanner scanner) {
        System.out.print("Digite a senha do gerente: ");
        String senha = scanner.nextLine();

        if (gerente.validarSenha(senha)) {
            System.out.printf("Faturamento do dia: R$ %.2f\n", faturamentoTotal);
        } else {
            System.out.println("Acesso negado.");
        }
    }

    public void listarFuncionarios() {
        for (Atendente a : atendentes) {
            a.exibirFuncionario();
        }
        caixa.exibirFuncionario();
        gerente.exibirFuncionario();
    }

    private Mesa buscarMesa(int numero) {
        for (Mesa m : mesas) {
            if (m.getNumero() == numero) return m;
        }
        return null;
    }
}
