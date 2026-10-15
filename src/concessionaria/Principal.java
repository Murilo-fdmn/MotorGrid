package concessionaria;

public class Principal {

    public static void main(String[] args) {

        Endereco endereco = new Endereco(
            "Rua das Flores",
            "100",
            "Centro",
            "Videira",
            "SC",
            "89560-000"
        );

        Loja loja = new Loja("Concessionaria Central", endereco);

        Produto carro1 = new Produto(
            1, "Toyota", "Corolla", 2024, 145000.00
        );

        Produto carro2 = new Produto(
            2, "Honda", "Civic", 2023, 130000.00
        );

        loja.getEstoque().inserir(carro1);
        loja.getEstoque().inserir(carro2);

        System.out.println("\n--- ESTOQUE ---");
        loja.getEstoque().listar();

        System.out.println("\n--- BUSCAR CARRO ---");
        Produto encontrado = loja.getEstoque().buscar(1);

        if (encontrado != null) {
            System.out.println("Modelo: " + encontrado.getModelo());
        }

        Produto carroAtualizado = new Produto(
            1, "Toyota", "Corolla", 2025, 150000.00
        );

        loja.getEstoque().atualizar(1, carroAtualizado);

        loja.getEstoque().remover(2);

        System.out.println("\n--- ESTOQUE FINAL ---");
        loja.getEstoque().listar();
    }
}


