
import java.util.ArrayList;

public class Mesa {
    private int numero;
    private int capacidade;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    // Novo método para encontrar a melhor mesa
    public static Mesa alocarMesa(ArrayList<Mesa> mesas, int quantidadePessoas) {
        Mesa melhorMesa = null;

        for (Mesa mesa : mesas) {
            if (mesa.getCapacidade() >= quantidadePessoas && quantidadePessoas >= mesa.getCapacidade() * 0.5) {
                if (melhorMesa == null || mesa.getCapacidade() < melhorMesa.getCapacidade()) {
                    melhorMesa = mesa;
                }
            }
        }

        return melhorMesa;
    }
}          