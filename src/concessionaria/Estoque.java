package concessionaria;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos;

    public Estoque() {
        produtos = new ArrayList<Produto>();
    }

    public void inserir(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public Produto buscar(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }

        return null;
    }

    public boolean atualizar(int id, Produto novoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.set(i, novoProduto);
                System.out.println("Produto atualizado!");
                return true;
            }
        }

        System.out.println("Produto nao encontrado.");
        return false;
    }

    public boolean remover(int id) {
        Produto produto = buscar(id);

        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido!");
            return true;
        }

        System.out.println("Produto nao encontrado.");
        return false;
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(
                "ID: " + produto.getId()
                + " | Marca: " + produto.getMarca()
                + " | Modelo: " + produto.getModelo()
                + " | Ano: " + produto.getAno()
                + " | Preco: R$ " + produto.getPreco()
            );
        }
    }
}

   
