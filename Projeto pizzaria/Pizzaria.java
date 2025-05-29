//Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533


import java.util.Scanner;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPizzaria sistema = new SistemaPizzaria();

        System.out.println("BEM-VINDO À PIZZARIA CHE BELLA PIZZA!");

        int opcao = 0;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar chegada de cliente");
            System.out.println("2. Alocar cliente em mesa");
            System.out.println("3. Anotar pedido");
            System.out.println("4. Gerar conta");
            System.out.println("5. Gerar faturamento acumulado");
            System.out.println("6. Listar funcionários");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> sistema.registrarChegada(scanner);
                case 2 -> sistema.alocarCliente(scanner);
                case 3 -> sistema.anotarPedido(scanner);
                case 4 -> sistema.gerarConta(scanner);
                case 5 -> sistema.gerarFaturamento(scanner);
                case 6 -> sistema.listarFuncionarios();
                case 7 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}
