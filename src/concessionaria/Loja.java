package concessionaria;


public class Loja {

    private String nome;
    private Endereco endereco;
    private Estoque estoque;

    public Loja() {
        estoque = new Estoque();
    }

    public Loja(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.estoque = new Estoque();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}

  