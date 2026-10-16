
package concessionaria;

public class Principal {

    public static void main(String[] args) {

        // Criacao da loja
        Endereco endereco = new Endereco(
                "Rua das Flores",
                "100",
                "Centro",
                "Videira",
                "SC",
                "89560-000"
        );

        Loja loja = new Loja("Concessionaria Central", endereco);

        // HERANCA
        Cliente cliente = new Cliente(
                1,
                "Carlos Silva",
                "11111111111",
                "49999999999",
                "carlos@email.com"
        );

        Funcionario funcionario = new Funcionario(
                2,
                "Ana Souza",
                "22222222222",
                "48888888888",
                "Vendedora",
                2500.00
        );

        // POLIMORFISMO
        Pessoa pessoa1 = cliente;
        Pessoa pessoa2 = funcionario;

        System.out.println("--- POLIMORFISMO ---");
        System.out.println(pessoa1.apresentarDados());
        System.out.println(pessoa2.apresentarDados());

        // CADASTRO DE VEICULOS
        Produto carro1 = new Produto(
                1, "Toyota", "Corolla", 2024, 145000.00
        );

        Produto carro2 = new Produto(
                2, "Honda", "Civic", 2023, 130000.00
        );

        loja.getEstoque().inserir(carro1);
        loja.getEstoque().inserir(carro2);

        // READ - listar
        System.out.println("\n--- ESTOQUE ---");
        loja.getEstoque().listar();

        // SOBRECARGA - buscar por ID
        System.out.println("\n--- BUSCA POR ID ---");
        Produto encontradoId = loja.getEstoque().buscar(1);

        if (encontradoId != null) {
            System.out.println("Encontrado: " + encontradoId.getModelo());
        }

        // SOBRECARGA - buscar por modelo
        System.out.println("\n--- BUSCA POR MODELO ---");
        Produto encontradoModelo = loja.getEstoque().buscar("Corolla");

        if (encontradoModelo != null) {
            System.out.println("Encontrado: " + encontradoModelo.getModelo());
        }

        // UPDATE - atualizar
        System.out.println("\n--- ATUALIZACAO ---");

        Produto carroAtualizado = new Produto(
                1, "Toyota", "Corolla", 2025, 150000.00
        );

        loja.getEstoque().atualizar(1, carroAtualizado);

        // DELETE - remover
        System.out.println("\n--- REMOCAO ---");
        loja.getEstoque().remover(2);

        // RESULTADO FINAL
        System.out.println("\n--- ESTOQUE FINAL ---");
        loja.getEstoque().listar();
    }
}
