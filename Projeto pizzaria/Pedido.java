//Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533


public class Pedido {
    private String descricao;
    private int quantidade;
    private double valorUnitario;

    public Pedido(String descricao, int quantidade, double valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public double calcularTotal() {
        return quantidade * valorUnitario;
    }

    public void exibirPedido() {
        System.out.println(quantidade + "x " + descricao + " - R$ " + valorUnitario + " cada | Total: R$ " + calcularTotal());
    }
    
  


}