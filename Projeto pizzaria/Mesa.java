//Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533

import java.util.List;
import java.util.ArrayList;

public class Mesa {
    private int numero;
    private int capacidade;
    private boolean ocupada; 
    private Cliente cliente;
    private List<Pedido>pedidos;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = false;
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
        this.cliente = null;
        this.pedidos.clear();
    }
    
     public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // método para encontrar a melhor mesa
    public static Mesa alocarMesa(ArrayList<Mesa> mesas, int quantidadePessoas) {
        Mesa melhorMesa = null;

        for (Mesa mesa : mesas) {
            // Verifica se a mesa está desocupada e se ela é adequada
            if (!mesa.isOcupada() && mesa.getCapacidade() >= quantidadePessoas && quantidadePessoas >= mesa.getCapacidade() * 0.5) {
                if (melhorMesa == null || mesa.getCapacidade() < melhorMesa.getCapacidade()) {
                    melhorMesa = mesa;
                }
            }
        }

        if (melhorMesa != null) {
            melhorMesa.ocupar();
        }

        return melhorMesa;
    }
}
