//Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533


public class Cliente {
    private String nomeRepresentante;
    private int quantidadePessoas;

    public Cliente(String nomeRepresentante, int quantidadePessoas) {
        this.nomeRepresentante = nomeRepresentante;
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

}          